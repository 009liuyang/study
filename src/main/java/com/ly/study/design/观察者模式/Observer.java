package com.ly.study.design.观察者模式;

/**
 * @Author : ly
 * @Date : 2019-05-31 18:53
 * @description :
 */
public abstract class Observer {

    protected Subject subject;
    public abstract void update();
}
