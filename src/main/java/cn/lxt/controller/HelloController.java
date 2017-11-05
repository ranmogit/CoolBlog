package cn.lxt.controller;

import cn.lxt.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuwen on 2017/10/27.
 */
@Controller
public class HelloController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "hello world,";
    }

    @RequestMapping(value = "/lxt")
    public String lxt(){
        System.out.println("OK");
        return "lxt.html";
    }

}
