package com.ly.study.设计模式.观察者模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-03 14:38
 * @description :
 */
public class F_Observer extends Observer {

    @Override
    public void update(String msg) {
        System.out.println(F_Observer.class.getName() + " : " + msg);
    }
}
