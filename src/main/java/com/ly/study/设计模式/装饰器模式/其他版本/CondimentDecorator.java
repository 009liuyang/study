package com.ly.study.设计模式.装饰器模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:45
 * @description : 这是继承Beverage的抽象装饰者，接下来所有具体的装饰者都要继承CondimentDecorator
 */
public abstract class CondimentDecorator extends Beverage {

    /**
     *所有的调料装饰者都必须重新实现该方法，因为调料的该方法应该得到扩充，方法实现不同于原来方法
     */
    @Override
    public abstract String getDescription();

}
