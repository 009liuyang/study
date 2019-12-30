package com.ly.study.design.单例模式;

/**
 * @Author : ly
 * @Date : 2019-11-05 17:26
 * @description : 懒汉试
 */
public class LHSingleton {

    private static LHSingleton singleton;
    private LHSingleton(){};

    public static synchronized LHSingleton getInstence(){
        if(singleton == null){
            singleton = new LHSingleton();
        }
        return singleton;
    }
}
