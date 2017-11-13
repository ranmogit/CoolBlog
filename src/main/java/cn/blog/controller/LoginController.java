package cn.blog.controller;

import cn.blog.bean.User;
import cn.blog.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by liuwen on 2017/11/13.
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 系统管理员登录action
     * @param name 账号
     * @param password 密码
     * @return statu 成功返回200，失败返回500
     */
    @RequestMapping(value = "/ajaxLogin")
    public int ajaxLogin(@Param("name")String name,@Param("password")String password){
        User user = new User(name,password);
        int statu = userService.queryUser(user);
        return statu;
    }
}
