package com.ly.study.rateLimit.strategy;

/**
 * @ClassName RateLimitContext
 * @Author liuyang
 * @Date 2020-01-11 11:55
 **/
public class RateLimitContext {

    private RateLimitStrategy rateLimitStrategy;

    public RateLimitContext(RateLimitStrategy rateLimitStrategy) {
        this.rateLimitStrategy = rateLimitStrategy;
    }

    public void execute() throws InterruptedException {
        RateLimitStrategy.LimitResult result = rateLimitStrategy.doRateLimit();
        if(result.isThrough()){
            System.out.println(result.isThrough());
            result.getTimeUnit().sleep(result.getDuration());
            rateLimitStrategy.afterProcess(result.getHandle());
        }
    }
}
