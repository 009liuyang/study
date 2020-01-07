package com.ly.study.design.装饰器模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:44
 * @description :
 */

/**
 *区别于Shape，Beverage采用抽象类
 *通常装饰者模式是采用抽象类，但是在Java中可以使用接口
 */
public abstract class Beverage {

    public String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
