package cn.blog.shiro;

import cn.blog.bean.User;
import cn.blog.dao.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();      //拓展：通过这种方式也能拿到用户名
        String password = new String((char[]) token.getCredentials());      //重点
        User user = userMapper.selectByNameAndPassword(new User(username,password));
        if (user==null){
            System.out.println("用户名密码错误");
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
