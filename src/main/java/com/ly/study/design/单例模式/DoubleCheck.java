package com.ly.study.design.单例模式;

/**
 * @Author : ly
 * @Date : 2019-11-05 17:47
 * @description : 双重锁校验
 */
public class DoubleCheck {

    private static DoubleCheck instance;
    private DoubleCheck(){};

    public static DoubleCheck getInstance(){
        if(instance == null){
            synchronized (DoubleCheck.class){
                if(instance == null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }

}
