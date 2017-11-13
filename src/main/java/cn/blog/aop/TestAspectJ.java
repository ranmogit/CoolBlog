package cn.blog.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Aspect     //定义一个切面类
@Configuration
public class TestAspectJ {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /*
    定义切入点
    execution表达式：
        *表示所有返回值，空格加路径，..表示service下的所有子包，*所有类方法，（..）表示方法里参数任意
     */
    @Pointcut("execution(* cn.blog.service..*(..))")
    public void pointcutService(){}

    @Before("pointcutService()")
    public void beforeMethod(){
        redisTemplate.opsForValue().set("name","lxt");
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
        System.out.println("++++++++++++++++++++");
    }

    @After("pointcutService()")
    public void afterMethod(){
        System.out.println("--------------------");
    }

}
