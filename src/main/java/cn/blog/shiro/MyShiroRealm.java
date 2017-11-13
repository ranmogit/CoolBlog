package cn.blog.shiro;

import cn.blog.bean.User;
import cn.blog.service.UsersService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UsersService usersService;

    /**
     * 用于获取登录成功后的角色、权限等信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 验证当前登录的Subject
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //拿到账号（username）
        String username = (String) token.getPrincipal();
        System.out.println("username=:"+username);
        //检查token的信息
        System.out.println(token.getCredentials());

        User user = usersService.findByName(username);
        if (user==null){
            return null;
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return info;
    }
}
