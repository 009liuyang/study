package com.ly.study.rateLimit.strategy.impl;

import com.ly.study.rateLimit.config.RateLimitConfiguration;
import com.ly.study.rateLimit.strategy.RateLimitStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LeakyBucketStrategy
 * @Author liuyang
 * @Date 2020-01-11 12:06
 * 漏桶算法
 **/

@Slf4j
@Service
public class LeakyBucketStrategy implements RateLimitStrategy, InitializingBean, DisposableBean {

    @Autowired
    private RateLimitConfiguration properties;

    private BlockingQueue<Leaky> bucket;
    private volatile boolean start = true;

    @Override
    public LimitResult doRateLimit() {
        boolean b = false;
        try {
            //向桶中加入水滴
            b = bucket.offer(new Leaky(), properties.getLeakyBucket().getInflowWaitTimeoutMs(), TimeUnit.MILLISECONDS);
            log.info("向漏桶中添加水滴:[{}].{}", b, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            log.error("向漏桶中添加水滴时异常", e);
            Thread.currentThread().interrupt();
        }

        return new LimitResult(b, null, TimeUnit.SECONDS, 0);
    }

    @Override
    public void destroy(){
        start = false;
    }

    @Override
    public void afterPropertiesSet() {
        bucket = new ArrayBlockingQueue<>(properties.getLeakyBucket().getBucketSize());

        long timeWindowMs = properties.getLeakyBucket().getTimeWindowMs();
        long outflowSize = properties.getLeakyBucket().getOutflowSize();
        long interval = timeWindowMs / outflowSize;

        new Thread(()-> {
            while (start){
                try {
                    // 漏桶流出的速率
                    bucket.take();
                    TimeUnit.MILLISECONDS.sleep(interval);
                    log.info("从桶中取出水滴:[{}].{}", interval, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }catch (Exception e){
                    log.error("从漏桶中流出水滴异常", e);
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    static class Leaky{}
}
