package com.ly.study.rateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RateLimiterTest {

    public static void main(String[] args) {


        RateLimiter rateLimiter = RateLimiter.create(5);

        System.out.println(rateLimiter.getRate());

        for (int i = 0; i <10 ; i++) {
            new Thread(() -> {
                rateLimiter.acquire();
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }).start();
        }




    }
}
