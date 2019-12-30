package com.ly.study.design.代理模式.Cglib代理;

/**
 * @Author : ly
 * @Date : 2019-11-12 18:25
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Car carNoInterface = (Car)cglibProxy.getInstance(new Car());
        carNoInterface.run();
    }

}
