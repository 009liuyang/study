package com.ly.study.design.代理模式.JDK代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : ly
 * @Date : 2019-11-12 18:18
 * @description :
 */
public class CarInvocation implements InvocationHandler {

    private Car car;

    public CarInvocation(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        Object result = method.invoke(car, args);
        System.out.println("after");

        return result;
    }
}

