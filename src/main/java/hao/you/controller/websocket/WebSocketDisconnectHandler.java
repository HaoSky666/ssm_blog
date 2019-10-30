package hao.you.controller.websocket;

import hao.you.domain.Login;
import hao.you.domain.ParticipantRepository;
import hao.you.domain.User;
import hao.you.enums.LoginTypeEnum;
import hao.you.service.LoginService;
import hao.you.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Date;
import java.util.Map;

/**
 * websocket断开连接处理，监听SessionDisconnectEvent事件，当有人下线就通知其他用户
 */
@Component
public class WebSocketDisconnectHandler implements ApplicationListener<SessionDisconnectEvent> {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;
    /**
     * 当sessionDisconnectEvent发布时，此方法将被调用，从事件中的message取出websocket sessionAttributes
     * 从中取出离开的User，将在线用户map中删除该用户，通知其他用户
     * @param sessionDisconnectEvent
     */
    public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
        Map<String, Object> sessionAttributes = headerAccessor.getSessionAttributes();
        User disconnectSession = (User) sessionAttributes.get("user");
        String disconnectUserName = disconnectSession.getUser_name();
        if (participantRepository.containsUserName(disconnectUserName)){
            User removeUser = participantRepository.remove(disconnectUserName);
            removeUser.setLogoutDate(new Date());
            //保存登出信息
            User userByName = userService.getUserByName(removeUser.getUser_name());
            Login loginInfo = Login.builder().userId(userByName == null ? null : userByName.getUser_id()).userName(removeUser.getUser_name()).status(LoginTypeEnum.LOGOUT.getCode()).createTime(new Date()).build();
            loginService.addLoginInfo(loginInfo);
            messagingTemplate.convertAndSend("/topic/logout", removeUser);
        }
    }
}
