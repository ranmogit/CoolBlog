package cn.lxt.controller;

import cn.lxt.bean.User;
import cn.lxt.service.TestService;
import cn.lxt.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
