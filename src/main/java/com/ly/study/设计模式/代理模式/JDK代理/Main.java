package com.ly.study.设计模式.代理模式.JDK代理;

import java.lang.reflect.Proxy;

/**
 * @Author : ly
 * @Date : 2019-11-12 18:19
 * @description :
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(new Integer("666").hashCode());

        CarInvocation carInvocation = new CarInvocation(new CarImpl());

        Car car = (Car)Proxy.newProxyInstance(Main.class.getClassLoader(), CarImpl.class.getInterfaces(), carInvocation);
        car.run();

    }
}
