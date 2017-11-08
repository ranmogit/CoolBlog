package cn.lxt.controller;

import cn.lxt.bean.User;
import cn.lxt.service.UsersService;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/login")
    @ResponseBody
    public User login(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter("name");
        User user = usersService.findByName(username);

        //给这个User创建一个token

        return user;
    }

    /*@PostMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request, Map<String,Object> map){
        //如果登录则失败从request中获取shiro处理的异常
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println(exception);
        System.out.println("1");
        String msg="";

        return "OK";
    }*/
}
