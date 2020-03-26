package com.ly.study.cacheHelper;


import com.ly.study.cacheHelper.map.MapCache;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MapCache cache = new MapCache();

        cache.put("key","value", 3, true);

        System.out.println(cache.get("key"));

        Thread.sleep(4000);

        System.out.println(cache.get("key"));


    }
}
