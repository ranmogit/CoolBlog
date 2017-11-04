package cn.lxt.controller;

import cn.lxt.bean.User;
import cn.lxt.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class JspController {
    @RequestMapping(value = "zst")
    public String zst(){
        return "zst.jsp";
    }

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "user")
    @ResponseBody
    public String queryUser(){
        String name="lxt";
        User user = userRepository.findUserByName(name);
        System.out.println(user.getPassword());
        return "OK";
    }

}
