package hao.you.controller;

import hao.you.domain.Message;
import hao.you.domain.MessageRecordDo;
import hao.you.domain.User;
import hao.you.enums.MessageTypeEnum;
import hao.you.service.LoginService;
import hao.you.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * 发送消息控制器
 */
@Controller
public class MessageController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    /**
     * 接收并且转发消息
     * @param message
     */
    @MessageMapping("chat/message")
    public void receiveMessage(Message message){
        message.setSendDate(new Date());
        message.setMessageType("text");
        //保存聊天信息
        User userByName = userService.getUserByName(message.getUserName());
        MessageRecordDo messageRecordDo = MessageRecordDo.messageRecordBuilder()
                .userId(userByName == null ? null : userByName.getUser_id())
                .userName(message.getUserName()).content(message.getContent())
                .messageType(MessageTypeEnum.TEXT.getCode()).createTime(new Date()).build();
        loginService.addMessageRecord(messageRecordDo);
        messagingTemplate.convertAndSend("/topic/chat/message", message);
    }

    /**
     * 接收转发图片
     * @param request
     * @param imageFile
     * @param userName
     * @return
     */
    @RequestMapping(value = "upload/image", method = RequestMethod.POST)
    @ResponseBody
    public String handleUploadImage(HttpServletRequest request, @RequestParam("image")MultipartFile imageFile, @RequestParam("userName")String userName){
        if (!imageFile.isEmpty()){
            String imageName = userName + "_" + (int)(Math.random() * 1000000) + ".jpg";
            String path = request.getSession().getServletContext().getRealPath("/images/media")  +"/" + imageName;
            File localImageFile = new File(path);
            try {
                //上传图片到目录
                byte[] bytes = imageFile.getBytes();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localImageFile));
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
                Message message = new Message();
                message.setMessageType("image");
                message.setUserName(userName);
                message.setSendDate(new Date());
                message.setContent(request.getContextPath() + "/images/media/" + imageName);

                //保存发送图片信息
                User userByName = userService.getUserByName(message.getUserName());
                MessageRecordDo messageRecordDo = MessageRecordDo.messageRecordBuilder()
                        .userId(userByName == null ? null : userByName.getUser_id())
                        .userName(userName).content(message.getContent())
                        .messageType(MessageTypeEnum.IMAGE.getCode()).createTime(new Date()).build();
                loginService.addMessageRecord(messageRecordDo);

                messagingTemplate.convertAndSend("/topic/chat/message", message);
            } catch (IOException e) {
                return "upload false";
            }
        }
        return "upload success";
    }
}
