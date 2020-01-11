package com.ly.study.cacheHelper.map;

import com.ly.study.cacheHelper.Handler.RefreshHandler;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class MapCache<K,V> {

    //存储数据的容器
    private ConcurrentHashMap<K,SoftReference<CacheWrapper>> concurrentHashMap = new ConcurrentHashMap();

    public void put(K k, V v, int expire, boolean refresh){

        CacheWrapper cacheWrapper = new CacheWrapper();
        cacheWrapper.setObject(v);
        cacheWrapper.setExpire(expire);
        cacheWrapper.setLoadTime(System.currentTimeMillis());
        cacheWrapper.setRefresh(refresh);

        SoftReference<CacheWrapper> softReference = new SoftReference<>(cacheWrapper);
        concurrentHashMap.put(k,softReference);
    }

    public V get(K k){
        if(k == null){
            return null;
        }

        CacheWrapper<V> cacheWrapper;
        SoftReference<CacheWrapper> softReference = concurrentHashMap.get(k);
        if(softReference != null){
            cacheWrapper = softReference.get();

            if(cacheWrapper.isExpire()){
                return null;
            }

            if(cacheWrapper.isRefresh() && System.currentTimeMillis()-cacheWrapper.getLoadTime()<cacheWrapper.getRefreshTime()*1000){
                new RefreshHandler().doRefresh(cacheWrapper);
                return cacheWrapper.getObject();
            }
            return cacheWrapper.getObject();
        }

        return null;
    }



}
