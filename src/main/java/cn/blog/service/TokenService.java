package cn.blog.service;

import cn.blog.bean.User;

import java.util.Map;


public interface TokenService {

    public Map<String,Object> createToken(User user);
}
