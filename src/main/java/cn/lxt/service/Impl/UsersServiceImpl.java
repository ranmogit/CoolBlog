package cn.lxt.service.Impl;

import cn.lxt.bean.User;
import cn.lxt.bean.UserExample;
import cn.lxt.dao.UserMapper;
import cn.lxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int login(User user) {
        int row =0;
        row = userMapper.insert(user);
        return row;
    }

    @Override
    public User findByName(String username) {
        /*UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(username);*/
        return userMapper.queryOneByName(username);
    }
}
