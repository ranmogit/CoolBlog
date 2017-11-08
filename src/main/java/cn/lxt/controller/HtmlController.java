package cn.lxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @RequestMapping("/index")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/lxt")
    public String lxt(){
        return "lxt.html";
    }

    @RequestMapping("/success")
    public String success(){
        return "success.html";
    }
}
