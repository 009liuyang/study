package com.ly.study.cacheHelper.Handler;

import com.ly.study.cacheHelper.map.CacheWrapper;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RefreshHandler {


    /**
     * 刷新缓存线程池
     */
    private final ThreadPoolExecutor refreshThreadPool = new ThreadPoolExecutor(5, 20, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10000));


    public void doRefresh(CacheWrapper cacheWrapper){

        refreshThreadPool.execute(new RefreshTask(cacheWrapper));
    }


    class RefreshTask implements Runnable{

        private CacheWrapper cacheWrapper;

        public RefreshTask(CacheWrapper cacheWrapper){
            this.cacheWrapper = cacheWrapper;
        }

        @Override
        public void run() {

            // 默认把超时时间延长两倍
            cacheWrapper.setExpire(cacheWrapper.getExpire() * 2);
        }
    }

}
