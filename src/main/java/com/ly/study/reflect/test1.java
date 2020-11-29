package com.ly.study.reflect;

import com.ly.study.cacheHelper.annotation.Cache;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class test1 {

    private static final ThreadLocal<String> threadLocal1=new ThreadLocal<String>();
    private static final ThreadLocal<String> threadLocal2=new ThreadLocal<String>();

    public static void main(String[] args){

        threadLocal1.set("hello1");
        threadLocal2.set("hello2");

    }


}
