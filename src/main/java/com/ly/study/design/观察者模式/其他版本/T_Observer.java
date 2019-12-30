package com.ly.study.design.观察者模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-03 14:38
 * @description :
 */
public class T_Observer extends Observer {

    @Override
    public void update(String msg) {
        System.out.println(T_Observer.class.getName() + " : " + msg);
    }
}
