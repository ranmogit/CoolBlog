package cn.blog.controller;

import cn.blog.bean.User;
import cn.blog.service.TokenService;
import cn.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TokenService tokenService;

    //登录成功后返回一个map
    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request){
        String username = request.getParameter("name");
        User user = usersService.findByName(username);
        //给这个User创建一个token
        Map<String,Object> map = tokenService.createToken(user.getId());
        map.put("user",user);
        return map;
    }

}
