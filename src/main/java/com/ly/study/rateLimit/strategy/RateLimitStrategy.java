package com.ly.study.rateLimit.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RateLimitStrategy
 * @Author liuyang
 * @Date 2020-01-11 11:54
 **/
public interface RateLimitStrategy {

    LimitResult doRateLimit();

    @Data
    @AllArgsConstructor
    class LimitResult {
        // 是否通过
        private boolean through;
        private Object handle;
        private TimeUnit timeUnit;
        // 延迟间隔
        private long duration;
    }
}
