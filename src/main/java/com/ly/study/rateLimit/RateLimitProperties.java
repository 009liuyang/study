package com.ly.study.rateLimit;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName RateLimitProperties
 * @Author liuyang
 * @Date 2020-01-11 13:58
 **/

@ConfigurationProperties(prefix = "ratelimit")
@Data
public class RateLimitProperties {

    private LeakyBucket leakyBucket = new LeakyBucket();
    private TokenBucket tokenBucket = new TokenBucket();
    private Semaphore semaphore = new Semaphore();

    @Data
    public static class LeakyBucket {

        // 桶容量
        private int bucketSize = 300;

        // 流出时间窗口（ms）
        private int timeWindowMs = 1000;

        // timeWindowMs内的流出数量
        private int outflowSize = 10;

        // 流入等待时间（ms），当桶容量满时，新请求将阻塞该时间以等待桶的空余空间
        private int inflowWaitTimeoutMs = 0;

        //private int qps = 500;
    }

    @Data
    public static class TokenBucket {
        private int bucketSize = 300;
        private int addTimeWindowMs = 1000;
        private int addSize = 300;
        private int acquireTimeoutMs = 0;
        private int qps = 500;
    }

    @Data
    public static class Semaphore {
        private int maxSemaphore = 300;
        private int acquireTimeoutMs = 0;
    }
}
