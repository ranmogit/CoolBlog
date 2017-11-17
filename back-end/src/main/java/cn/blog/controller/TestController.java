package cn.blog.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    @PostMapping(value = "testLogin")
    public Map<String,Object> testLogin(@RequestParam("name")String name,@RequestParam("password")String password){
        Map<String,Object> map = new HashMap<String,Object>();
        //创建subject实例
        Subject subject = SecurityUtils.getSubject();
        //判断当前的subject是否登录
        if (subject.isAuthenticated()==false){
            //将用户名和密码存入UsernamePasswordToken中
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            try {
                //将存有用户名和密码的token存进subject中
                subject.login(token);
            } catch (UnknownAccountException uae){
                System.out.println("没有用户名为"+token.getPrincipal()+"的用户");
            } catch (IncorrectCredentialsException ice){
                System.out.println("用户名为："+token.getPrincipal()+"的用户密码不正确");
            } catch (LockedAccountException lae){
                System.out.println("用户名为："+token.getPrincipal()+"的用户已被冻结");
            } catch (AuthenticationException e){
                System.out.println("未知错误！");
            }
        }
        return map;
    }
}
