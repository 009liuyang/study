package com.ly.study.distributedlock;

import com.ly.study.distributedlock.pojo.LockInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-01-13 18:09
 **/
@Slf4j
public abstract class AbstractLock implements IDistributedLock {

    protected static final String OK = "OK";

    protected static final String NX = "NX";

    protected static final String EX = "EX";

    private static final ThreadLocal<Map<String, LockInfo>> LOCK_START_TIME = new ThreadLocal<Map<String, LockInfo>>();


    @Override
    public boolean tryLock(String key, int lockExpire, int tryCnt, int interval) {

        if(interval <= 0){
            interval = 10;
        }

        boolean locked;
        for(int i=0; !(locked =getLock(key, lockExpire)) && i<tryCnt; i++){
            try {
                Thread.sleep(interval);
            }catch (InterruptedException e){
                log.error(e.getMessage(), e);
                Thread.currentThread().interrupt();
            }
        }

        if (locked) {
            Map<String, LockInfo> startTimeMap = LOCK_START_TIME.get();
            if (null == startTimeMap) {
                startTimeMap = new HashMap<>(2);
                LOCK_START_TIME.set(startTimeMap);
            }
            LockInfo info = new LockInfo();
            info.setLeaseTime(lockExpire * 1000);
            info.setStartTime(System.currentTimeMillis());
            startTimeMap.put(key, info);
        }
        return locked;
    }

    @Override
    public void release(String key) {
        Map<String, LockInfo> startTimeMap = LOCK_START_TIME.get();
        LockInfo info = null;
        if (null != startTimeMap) {
            info = startTimeMap.remove(key);
        }
        // 如果超过租约时间则不需要主到释放锁
        if (null != info) {
            if ((System.currentTimeMillis() - info.getStartTime()) >= info.getLeaseTime()) {
                log.warn("锁(" + key + ")的租约时间比实际执行时间短");
                return;
            }
        } else {
            log.warn("LockInfo is null for key " + key);
        }
        try {
            del(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * @param key
     * @param lockExpire
     * @return
     */
    protected abstract boolean getLock(String key, int lockExpire);

    /**
     * @param key
     */
    protected abstract void del(String key);
}
