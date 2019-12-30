package com.ly.study.design.代理模式.JDK代理;

/**
 * @Author : ly
 * @Date : 2019-11-12 18:17
 * @description :
 */
public class CarImpl implements Car {

    @Override
    public void run() {
        System.out.println("run ... ");
    }
}

