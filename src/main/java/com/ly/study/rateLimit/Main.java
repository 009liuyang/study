package com.ly.study.rateLimit;

import com.ly.study.rateLimit.strategy.RateLimitContext;
import com.ly.study.rateLimit.strategy.impl.LeakyBucketStrategy;

/**
 * @ClassName Main
 * @Author liuyang
 * @Date 2020-01-11 12:23
 **/
public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketStrategy lbs = new LeakyBucketStrategy();

        RateLimitContext context = new RateLimitContext(lbs);

        for (int i = 0; i <12 ; i++) {
            context.execute();
        }
    }
}
