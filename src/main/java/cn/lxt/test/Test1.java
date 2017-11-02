package cn.lxt.test;

import cn.lxt.DemoApplication;
import cn.lxt.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liuwen on 2017/11/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoApplication.class)
public class Test1 {

    @Autowired
    TestService testService;

    @Test
    public void test(){
        testService.reportCurrentTime();
        testService.reportCurrentTime5();
    }
}
