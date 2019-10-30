package hao.you.controller;

import hao.you.domain.Login;
import hao.you.domain.ParticipantRepository;
import hao.you.domain.User;
import hao.you.enums.LoginTypeEnum;
import hao.you.service.LoginService;
import hao.you.service.UserService;
import hao.you.utils.ToolMethodUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;//消息模板
    @Autowired
    private ParticipantRepository participantRepository; //在线用户存储
    //注册功能
    @RequestMapping("user/addUser")
    public String addUser(User user, Model model){
        List<User> allUser = userService.getAllUser();
        if(ToolMethodUtil.isNull(user.getUser_name())||ToolMethodUtil.isNull(user.getUser_password())){
            model.addAttribute("msg","账号或密码不能为空！");
            return "register";
        }
        for(User userList:allUser){
            if(user.getUser_name().equals(userList.getUser_name())){
                model.addAttribute("msg","用户已存在！");
                return "register";
            }
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setUser_record_date(sf.format(new Date()));
        userService.addUser(user);
        model.addAttribute("msg","注册成功！");
        return "register";
    }

    //登录功能
    @RequestMapping("user/login_fn")
    public String login_fn(User user, Model model, HttpSession session){
        if(ToolMethodUtil.isNull(user.getUser_name())||ToolMethodUtil.isNull(user.getUser_password())){
            model.addAttribute("msg","账号或密码不能为空！");
            return "login";
        }
        User query_user = userService.getUserByName(user.getUser_name());
        if(ToolMethodUtil.isNull(query_user)){
            model.addAttribute("msg","账户不存在！");
            return "login";
        }else{
            if(!user.getUser_password().equals(query_user.getUser_password())){
                model.addAttribute("msg","密码错误！");
                return "login";
            }
        }
        query_user.setUser_password(null);//设空防止泄露给其他用户
        session.setAttribute("user",query_user);
        return "redirect:../index";
    }

    //注销功能
    @RequestMapping("user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:../index";
    }

    //访问登录的一个跳板
    @RequestMapping("user/login")
    public String login(){
        return "login";
    }

    //访问注册的一个跳板
    @RequestMapping("user/register")
    public String register(){
        return "register";
    }

    //登录进入聊天室
    @RequestMapping("chat")
    public String loginIntoChatRoom(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/user/login";
        }else{
            user.setLoginDate(new Date());
            //保存登陆信息
            Login login = Login.builder().userId(user.getUser_id()).userName(user.getUser_name()).status(LoginTypeEnum.LOGIN.getCode()).createTime(new Date()).build();
            loginService.addLoginInfo(login);//添加登录信息入数据库
            messagingTemplate.convertAndSend("/topic/login", user);//向所有用户发送某用户登录信息
            participantRepository.add(user.getUser_name(), user);//存储用户，统计用户在线个数
            return "chat";
        }
    }
    /**
     * 返回当前在线人数
     * @return
     */
    @SubscribeMapping("/chat/participants")
    public Long getActiveUserNumber(){
        return Long.valueOf(participantRepository.getActiveSessions().values().size());
    }
}
