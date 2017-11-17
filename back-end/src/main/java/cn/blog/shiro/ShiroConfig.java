package cn.blog.shiro;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     *这是个自定义的认证类，继承子AuthorizingRealm，负责用户的认证和权限处理
     */
    @Bean
    public MyShiroRealm shiroRealm(){
        MyShiroRealm realm = new MyShiroRealm();
        return realm;
    }

    /** 安全管理器
     * 将realm加入securityManager
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        //注意是DefaultWebSecurityManager！！！
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
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
        //1。定义ShiroFilterFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //2.注册securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //3.1拦截器
        //LinkHashMap是有序的，shiro会根据添加的顺序进行拦截,在上面的优先级比较大
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //配置拦截器
        //anon，所有的url都可以匿名访问
        //authc：所有url都必须认证通过才可以访问
        //user，配置记住我或者认证通过才能访问
        //logout，退出登录
        filterChainDefinitionMap.put("/css/**","anon");     //运行匿名访问
        filterChainDefinitionMap.put("/images/**","anon");     //运行匿名访问
        filterChainDefinitionMap.put("/login.html","authc");     //运行匿名访问
        filterChainDefinitionMap.put("/testLogin","anon");     //运行匿名访问
        filterChainDefinitionMap.put("/Swagger-ui.html","anon");    //运行匿名访问
        filterChainDefinitionMap.put("/logout","logout");   //登出
        filterChainDefinitionMap.put("/**","authc");        //必须认证后才能访问
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        //3.2配置登录和登录成功之后的url
        //设置登录界面，如果不设置为寻找web根目录下的文件
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //设置登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/testSuccess");
        //设置登录未成功，也可以说无权限界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");


        //4.返回对象
        System.out.println("shiro拦截工厂注入类成功");
        return shiroFilterFactoryBean;
    }
}
