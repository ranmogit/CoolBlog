package cn.lxt.controller;

import cn.lxt.bean.configBean;
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

    /*@Value("${cn.lxt.controller.helloController.name}")
    private String name;
    @Value("${cn.lxt.controller.helloController.value}")
    private String value;*/
    @Autowired
    configBean configBean;

    /*@Autowired
    TestService testService;*/

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){

        /*testService.reportCurrentTime();
        testService.reportCurrentTime5();*/

        return configBean.getName()+"hello world,"+configBean.getValue();
    }

    @RequestMapping(value = "/lxt")
    public String lxt(){
        System.out.println("OK");
        return "lxt.html";
    }

}
