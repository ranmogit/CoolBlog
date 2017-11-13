package cn.blog.service.Impl;

import cn.blog.bean.User;
import cn.blog.dao.UserMapper;
import cn.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuwen on 2017/11/13.
 */
@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int queryUser(User user) {
        User user1 = userMapper.selectByNameAndPassword(user);
        int statu=200;
        if (user1!=null){
            statu=500;
        }
        return statu;
    }
}
