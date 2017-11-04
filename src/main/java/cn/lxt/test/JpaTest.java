package cn.lxt.test;

import cn.lxt.domain.User;
import cn.lxt.domain.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void baseTest(){
        String name = "lxt";
        User user=null;
        user = userRepository.findUserByName(name);
    }

}
