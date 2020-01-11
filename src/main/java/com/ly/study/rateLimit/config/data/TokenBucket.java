package com.ly.study.rateLimit.config.data;

import lombok.Data;

/**
 * @ClassName TokenBucket
 * @Author liuyang
 * @Date 2020-01-11 16:57
 **/
@Data
public class TokenBucket {

    /**
     * 桶容量
     */
    private int bucketSize = 300;

    /**
     * 添加令牌时间窗口（ms）
     */
    private int addTimeWindowMs = 1000;

    /**
     * addTimeWindowMs时间内 添加令牌的数量
     */
    private int addSize = 300;

    /**
     * 请求等待时间（ms），当桶内没有令牌时，新请求将阻塞该时间以等待桶的可用令牌
     */
    private int acquireTimeoutMs = 0;

    //private int qps = 500;
}
