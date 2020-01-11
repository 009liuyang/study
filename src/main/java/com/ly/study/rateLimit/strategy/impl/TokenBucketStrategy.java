package com.ly.study.rateLimit.strategy.impl;

import com.ly.study.rateLimit.config.RateLimitConfiguration;
import com.ly.study.rateLimit.strategy.RateLimitStrategy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TokenBucketStrategy
 * @Author liuyang
 * @Date 2020-01-11 16:55
 **/
@Service
public class TokenBucketStrategy implements RateLimitStrategy, InitializingBean, DisposableBean {

    @Autowired
    private RateLimitConfiguration properties;

    private BlockingQueue<TokenBucketStrategy.Token> bucket;
    private volatile boolean start = true;

    @Override
    public LimitResult doRateLimit() {

        Token token = null;
        try {
            //从桶中取出令牌
            token = bucket.poll(properties.getTokenBucket().getAcquireTimeoutMs(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new LimitResult(token!=null, null, TimeUnit.SECONDS, 0);
    }

    @Override
    public void destroy() {
        start = false;
    }

    @Override
    public void afterPropertiesSet(){
        //初始化桶的容量
        bucket = new ArrayBlockingQueue<>(properties.getTokenBucket().getBucketSize());

        long addSize = properties.getTokenBucket().getAddSize();
        long addTimeWindowMs = properties.getTokenBucket().getAddTimeWindowMs();
        long interval = addTimeWindowMs / addSize;

        new Thread(() -> {
            while (start) {
                try {
                    //以恒定的速率向桶中添加令牌
                    bucket.put(new Token());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class Token{
    }
}
