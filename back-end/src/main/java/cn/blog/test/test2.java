package cn.blog.test;

import cn.blog.bean.Handle;
import cn.blog.bean.HandleExample;
import cn.blog.dao.HandleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class test2 {

    @Autowired
    private HandleMapper handleMapper;

    @Test
    public void Test2(){
        List<Handle> list = handleMapper.selectByExample(new HandleExample());
        for (Handle handle:list){
            System.out.println(handle.getHandle());
        }
    }
}
