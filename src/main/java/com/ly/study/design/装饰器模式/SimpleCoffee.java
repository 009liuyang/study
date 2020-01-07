package com.ly.study.design.装饰器模式;

/**
 * 原价咖啡
 */
public class SimpleCoffee implements Coffee{

    /**
     * 原价咖啡 10元一杯
     * @return
     */
    @Override
    public double getCost() {
        return 10;
    }

}
