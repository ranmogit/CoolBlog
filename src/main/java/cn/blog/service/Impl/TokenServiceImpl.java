package cn.blog.service.Impl;

import cn.blog.bean.Token;
import cn.blog.bean.User;
import cn.blog.dao.TokenMapper;
import cn.blog.dao.UserMapper;
import cn.blog.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {

    private static final int Expire = 3600*12;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public Map<String, Object> createToken(User user) {
        User user1 = userMapper.selectByNameAndPassword(user);
        //创建TokenEntity参数
        String newtoken = UUID.randomUUID().toString();
        Date updateTime = new Date();
        Date expireTime = new Date(updateTime.getTime()+Expire*1000);

        Token token = new Token(newtoken,user1.getId(),updateTime,expireTime);
        //判断token是否已经存在,不存在就存入，存在就更新
        if (tokenMapper.findByToken(token)==null){
            tokenMapper.insert(token);
            System.out.println("存入成功");
        }else {
            tokenMapper.updateByToken(token);
            System.out.println("更新成功");
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token",token);
        return map;
    }
}
