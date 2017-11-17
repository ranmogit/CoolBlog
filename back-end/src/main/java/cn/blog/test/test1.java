package cn.blog.test;

import java.util.Date;

/**
 * Created by liuwen on 2017/11/15.
 */
public class test1 {
    public static void main(String[] args) {
        Date now = new Date();
        Date later = new Date(now.getTime()+3600*12);
        if (now.getTime()>later.getTime()){
            System.out.println("right");
        }else {
            System.out.println("wrong");
        }
        System.out.println(now);
        System.out.println(later);
    }
}
