package cn.blog.controller;

import cn.blog.bean.User;
import cn.blog.service.TokenService;
import cn.blog.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "登录验证",notes = "成功返回200，失败返回500,返回一个TokenJSON对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "账号名",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String")
    })
    @RequestMapping(value = "/ajaxLogin",method = RequestMethod.GET)
    public Map<String, Object> ajaxLogin(@RequestParam("name")String name, @RequestParam("password")String password){
        tokenService.checkExpire();
        Map<String, Object> map = new HashMap<String,Object>();
        User user = new User(name,password);
        int status = userService.queryUser(user);
        if (status==200){
            map = tokenService.createToken(user);
        }
        map.put("status",status);
        return map;
    }
}
