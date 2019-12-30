package com.ly.study.设计模式.装饰器模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:45
 * @description :
 * 摩卡，是具体的装饰者
 * 用一个实例变量记录饮料（被装饰者）
 * 装饰者和被装饰者通过组合来增强功能，实现功能的扩展，用组合来替代继承
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
