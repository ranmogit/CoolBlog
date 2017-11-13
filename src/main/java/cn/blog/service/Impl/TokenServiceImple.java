package cn.blog.service.Impl;

import cn.blog.bean.Token;
import cn.blog.dao.TokenMapper;
import cn.blog.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenServiceImple implements TokenService {

    private final static int EXPIRE = 3600*12;

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    //未完成功能:判断是否已存在，已存在覆盖掉
    public Map createToken(int userId) {
        Map<String,Object> map = new HashMap<String, Object>();
        //设置一个随机产生的token
        String token = UUID.randomUUID().toString();
        //设置创建时间
        Date createTime = new Date();
        //设置过期时间    创建日期加12小时
        Date expireTime = new Date(createTime.getTime()+EXPIRE*1000);

        //判断token是否已存在
        //这里先省略

        Token tokenEntity = new Token(userId,token,expireTime,createTime);
        //保存到数据库
        tokenMapper.insert(tokenEntity);

        System.out.println("存入成功");
        map.put("token",token);
        return map;
    }
}
