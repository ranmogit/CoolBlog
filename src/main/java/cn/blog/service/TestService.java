package cn.blog.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuwen on 2017/11/2.
 */
@Service
public class TestService {

    private final static SimpleDateFormat dateFor = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime(){
        System.out.println("线程一"+dateFor.format(new Date()));
    }

    @Async
    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime5(){
        System.out.println("线程五"+dateFor.format(new Date()));
    }
}
