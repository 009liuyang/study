package com.ly.study.design.装饰器模式;

/**
 * 半价咖啡装饰器实现类
 */
public class HalfPercentDecorator extends CoffeeDecorator {

    public HalfPercentDecorator(Coffee coffeeDecorator) {
        super(coffeeDecorator);
    }

    @Override
    public double getCost() {
        double price = super.getCost();
        return price*0.5;
    }
}
