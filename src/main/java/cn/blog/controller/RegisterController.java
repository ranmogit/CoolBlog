package cn.blog.controller;

import cn.blog.bean.User;
import cn.blog.service.TestService;
import cn.blog.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by liuwen on 2017/10/27.
 */
@Controller
public class RegisterController {

    @Autowired
    TestService testService;

    @Autowired
    UsersService usersService;

    @PostMapping("/Register")
    public String Register(@Param("name")String name,@Param("password")String password){
        User user = new User(name,password);
        int row = usersService.login(user);
        if (row==0){
            System.out.println("注册失败");
        }
        return "index.html";
    }


}
