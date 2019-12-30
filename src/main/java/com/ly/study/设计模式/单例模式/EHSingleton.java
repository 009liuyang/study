package com.ly.study.设计模式.单例模式;

/**
 * @Author : ly
 * @Date : 2019-11-05 17:43
 * @description : 饿汉试
 */
public class EHSingleton {

    private static EHSingleton instance = new EHSingleton();
    private EHSingleton(){};

    public static EHSingleton getInstance(){
        return instance;
    }
}
