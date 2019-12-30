package com.ly.study.design.代理模式.Cglib代理;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Author : ly
 * @Date : 2019-11-12 18:24
 * @description :
 */
public class CglibProxy implements MethodInterceptor{

    private Object car;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object object) {
        this.car = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.car.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
        System.out.println("事物开始");
        proxy.invokeSuper(obj, args);
        System.out.println("事物结束");
        return null;
    }

}
