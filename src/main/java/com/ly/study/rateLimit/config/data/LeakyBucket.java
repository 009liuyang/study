package com.ly.study.rateLimit.config.data;

import lombok.Data;

/**
 * @ClassName LeakyBucket
 * @Author liuyang
 * @Date 2020-01-11 15:53
 **/
@Data
public class LeakyBucket {

    /**
     * 桶容量
     */
    private int bucketSize = 0;

    /**
     * 流出时间窗口（ms）
     */
    private int timeWindowMs = 0;

    /**
     * timeWindowMs内的流出数量
     */
    private int outflowSize = 0;

    /**
     * 流入等待时间（ms），当桶容量满时，新请求将阻塞该时间以等待桶的空余空间
     */
    private int inflowWaitTimeoutMs = 0;

    //private int qps = 500;
}
