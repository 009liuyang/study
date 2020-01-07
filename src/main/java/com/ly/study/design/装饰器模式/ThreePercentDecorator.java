package com.ly.study.design.装饰器模式;

/**
 * 半价咖啡装饰器实现类
 */
public class ThreePercentDecorator extends CoffeeDecorator {

    public ThreePercentDecorator(Coffee coffeeDecorator) {
        super(coffeeDecorator);
    }

    @Override
    public double getCost() {
        double price = super.getCost();
        return price*0.7;
    }
}
