package cn.blog.service;

import cn.blog.bean.User;


public interface UsersService {

    public int login(User user);

    public User findByName(String username);
}
