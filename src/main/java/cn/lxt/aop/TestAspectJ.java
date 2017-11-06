package cn.lxt.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect     //定义一个切面类
@Configuration
public class TestAspectJ {

    /*
    定义切入点
    execution表达式：
        *表示所有返回值，空格加路径，..表示service下的所有子包，*所有类方法，（..）表示方法里参数任意
     */
    @Pointcut("execution(* cn.lxt.service..*(..))")
    public void pointcutService(){}

    @Before("pointcutService()")
    public void beforeMethod(){
        System.out.println("++++++++++++++++++++");
    }

    @After("pointcutService()")
    public void afterMethod(){
        System.out.println("--------------------");
    }

}
