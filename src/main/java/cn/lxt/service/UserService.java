package cn.lxt.service;

import cn.lxt.bean.User;
import cn.lxt.bean.UserExample;
import cn.lxt.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryAllUser(){
        return userMapper.selectByExample(new UserExample());
    }

    public List<User> queryByNameAndPassword(String name,String password){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(password);

        /*UserExample.Criteria criteria1 = example.createCriteria();
        criteria.andNameEqualTo("zst");
        criteria.andPasswordEqualTo("1123");
        example.or(criteria1);*/

        return userMapper.selectByExample(example);
    }

    public List<User> selectByNameAndPassword1(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        List name = new ArrayList();
        name.add("lxt");
        name.add("zst");
        map.put("name1",name);
        //map.put("name","lxt");
        map.put("password","1123");
        return userMapper.queryByNameAndPassword1(map);
    }
}
