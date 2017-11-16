package cn.blog.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BlogController {

    @PostMapping(value = "ajaxBlog")
    public Map<String,Object> ajaxBlog(){
        Map<String, Object> map = new HashMap<String,Object>();

        return map;
    }
}
