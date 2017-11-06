package cn.lxt.shiro;


import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class shiroConfig {

    /*@Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }*/

    /** 安全管理器
     * 将realm加入securityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        //注意是DefaultWebSecurityManager！！！
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        return securityManager;
    }

    /** shiro filter 工厂类
     * 1.定义ShiroFilterFactoryBean
     * 2.设置SecurityManager
     * 3.配置拦截器
     * 4.返回定义ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        //1
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //2
        //注册securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //3拦截器+配置登录和登录成功之后的url
        //LinkHashMap是有序的，shiro会根据添加的顺序进行拦截
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //配置不会被拦截的连接  这里顺序判断
        //anon，所有的url都可以匿名访问
        //authc：所有url都必须认证通过才可以访问
        //user，配置记住我或者认证通过才能访问
        //logout，退出登录
        filterChainDefinitionMap.put("/static/**","anon");
        //配置退出过滤器
        filterChainDefinitionMap.put("/logout","logout");
        //过滤连接自定义，从上往下顺序执行，所以用LinkHashMap /**放在最下边
        filterChainDefinitionMap.put("/**","authc");

        //设置登录界面，如果不设置为寻找web根目录下的文件
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置登录未成功，也可以说无权限界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("shiro拦截工厂注入类成功");

        //4返回
        return shiroFilterFactoryBean;
    }
}
