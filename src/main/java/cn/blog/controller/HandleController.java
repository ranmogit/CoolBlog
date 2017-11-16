package cn.blog.controller;


import cn.blog.bean.Handle;
import cn.blog.bean.HandleExample;
import cn.blog.dao.HandleMapper;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HandleController {

    @Autowired
    private HandleMapper handleMapper;

    @GetMapping(value = "ajaxHandle")
    public Map<String,Object> ajaxHandle(){
        Map<String, Object> map = new LinkedHashMap<String,Object>();
        List<Handle> handleList = handleMapper.selectByExample(new HandleExample());
        map.put("handle",handleList);
        return map;
    }
}
