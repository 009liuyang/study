package com.ly.study.distributedlock;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-01-13 18:07
 **/
public interface IDistributedLock {

    /**
     * 获取分布式锁
     *
     * @param key       锁Key
     * @param leaseTime 锁的租约时间（单位：秒）。当前线程在获取到锁以后，在租约时间到期以后，会自动释放锁。如果在租约时间到期之前，方法执行完毕了，也会释放锁。
     * @param tryCnt    尝试次数(默认值为：0)
     * @param interval  尝试获取锁的间隔时间，单位是毫秒（默认值为：10ms）
     * @return boolean
     */
    boolean tryLock(String key, int leaseTime, int tryCnt, int interval);

    /**
     * 释放锁
     *
     * @param key 锁Key
     */
    void release(String key);

}