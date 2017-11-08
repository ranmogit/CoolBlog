package cn.lxt.service;

import cn.lxt.bean.User;
import org.springframework.stereotype.Service;


public interface UsersService {

    public int login(User user);

    public User findByName(String username);
}
