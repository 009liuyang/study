package com.ly.study.rateLimit.strategy.impl;

import com.ly.study.rateLimit.RateLimitProperties;
import com.ly.study.rateLimit.strategy.RateLimitStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

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
public class LeakyBucketStrategy implements RateLimitStrategy, InitializingBean, DisposableBean {

    //桶
    private static BlockingQueue<Leaky> bucket;
    private RateLimitProperties.LeakyBucket properties;
    private volatile boolean start = true;

    public LeakyBucketStrategy(RateLimitProperties.LeakyBucket properties) {
        this.properties = properties;
        bucket = new ArrayBlockingQueue<>(properties.getBucketSize());
    }


    @Override
    public LimitResult doRateLimit() {
        boolean b = false;
        try {

            //向桶中加入水滴
            b = bucket.offer(new Leaky(), properties.getInflowWaitTimeoutMs(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            log.error("向漏桶中添加水滴时异常", e);
            Thread.currentThread().interrupt();
        }

        return new LimitResult(b, null, TimeUnit.SECONDS, 0);
    }

    @Override
    public void afterProcess(Object handle) {
    }

    @Override
    public void destroy(){
        start = false;
    }

    @Override
    public void afterPropertiesSet() {
        long timeWindowMs = properties.getTimeWindowMs();
        long outflowSize = properties.getOutflowSize();
        long interval = timeWindowMs / outflowSize;

        new Thread(()-> {
            while (start){
                try {

                    // 漏桶流出的速率
                    bucket.take();
                    TimeUnit.MILLISECONDS.sleep(interval);
                    log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "取出");
                }catch (Exception e){
                    log.error("从漏桶中流出水滴异常", e);
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }


    static class Leaky{}
}
