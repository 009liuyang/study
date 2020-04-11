package com.ly.study.distributedlock.pojo;

import lombok.Data;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-01-13 18:15
 **/
@Data
public class LockInfo {

    private Long startTime;

    private Integer leaseTime;
}
