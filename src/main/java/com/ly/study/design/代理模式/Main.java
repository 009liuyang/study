package com.ly.study.design.代理模式;

/**
 * @Author : ly
 * @Date : 2019-06-04 19:56
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        AbstractObject proxy = new ProxyObject(new RealObject());
        proxy.operation();
    }
}
