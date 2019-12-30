package com.ly.study.设计模式.装饰器模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:44
 * @description : 被装饰类继承Beverage抽象类，最终会通过装饰者动态添加上新的行为
 */

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
