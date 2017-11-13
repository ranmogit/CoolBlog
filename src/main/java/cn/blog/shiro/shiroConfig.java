package cn.blog.shiro;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class shiroConfig {

    /**
     * 负责shiroBean的生命周期
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 对密码进行编码，防止密码在数据库里明码保存
     * 当然在登录认证的时候，这个类页负责对form里输入的密码进行编码
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    /**
     *这是个自定义的认证类，继承子AuthorizingRealm，负责用户的认证和权限处理
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public MyShiroRealm shiroRealm(){
        MyShiroRealm realm = new MyShiroRealm();
        //realm.setCredentialsMatcher(hashedCredentialsMatcher());
        return realm;
    }

    /**
     *缓存管理，用户登录后，把用户信息和权限信息缓存起来，然后每次用户请求时
     * 放入用户的session中，如果不设置这个Bean，每个请求都会查询一次数据库
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
        return ehCacheManager;
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
        //1
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //2
        //注册securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        System.out.println("11");
        //3
        // 拦截器+配置登录和登录成功之后的url
        //LinkHashMap是有序的，shiro会根据添加的顺序进行拦截
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        //配置不会被拦截的连接  这里顺序判断
        //anon，所有的url都可以匿名访问
        //authc：所有url都必须认证通过才可以访问
        //user，配置记住我或者认证通过才能访问
        //logout，退出登录
        filterChainDefinitionMap.put("/JQuery/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        //配置退出过滤器
        filterChainDefinitionMap.put("/example1","anon");
        filterChainDefinitionMap.put("/lxt","anon");
        filterChainDefinitionMap.put("/user","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/success","anon");
        filterChainDefinitionMap.put("/index","anon");
        filterChainDefinitionMap.put("/Register","anon");
        filterChainDefinitionMap.put("/logout","logout");
        //过滤连接自定义，从上往下顺序执行，所以用LinkHashMap /**放在最下边
        filterChainDefinitionMap.put("/**","authc");
        //设置登录界面，如果不设置为寻找web根目录下的文件
        shiroFilterFactoryBean.setLoginUrl("/lxt");
        //设置登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/success");
        //设置登录未成功，也可以说无权限界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("shiro拦截工厂注入类成功");

        //4
        //返回
        return shiroFilterFactoryBean;
    }
}
