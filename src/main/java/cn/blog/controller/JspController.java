package cn.blog.controller;

import cn.blog.bean.User;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/")
public class JspController {
    @RequestMapping(value = "zst")
    public String zst(){
        return "zst.jsp";
    }

    @Autowired
    UserService userService;

    @RequestMapping(value = "All")
    @ResponseBody
    public List<User> quertAll(){
        return userService.queryAllUser();
    }

    @RequestMapping(value = "example")
    @ResponseBody
    public List<User> queryByExample(){
        return userService.queryByNameAndPassword("lxt","1123");
    }

    @RequestMapping(value = "example1")
    @ResponseBody
    public List<User> queryByExample1(){
        return userService.selectByNameAndPassword1();
    }
}
