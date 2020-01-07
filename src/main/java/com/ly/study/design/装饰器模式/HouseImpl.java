package com.ly.study.design.装饰器模式;

/**
 * 目标接口实现类
 */
public class HouseImpl implements House {

    @Override
    public void output() {
        System.out.println("我的房子");
    }
}
