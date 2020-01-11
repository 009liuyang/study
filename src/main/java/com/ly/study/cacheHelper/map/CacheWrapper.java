package com.ly.study.cacheHelper.map;

import lombok.Data;

@Data
public class CacheWrapper<V> {

    private V object;

    /**
     * 过期时间
     * 单位:秒
     */
    private int expire;

    private long loadTime;

    /**
     * 快要过期时是否重新加载
     */
    private boolean refresh = false;

    /**
     * 距离重新加载的时间
     * 默认10秒
     */
    private long refreshTime = 10;

    /**
     * 是否过期
     * @return
     */
    public boolean isExpire(){
        if(expire > 0){
            System.out.println(System.currentTimeMillis() - loadTime > expire*1000);
            return System.currentTimeMillis() - loadTime > expire*1000;
        }else {
            return false;
        }
    }

}
