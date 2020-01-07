package com.ly.study.design.装饰器模式;

/**
 * 咖啡装饰器
 */
public class CoffeeDecorator implements Coffee{

   public Coffee coffeeDecorator;

    public CoffeeDecorator(Coffee coffeeDecorator) {
        this.coffeeDecorator = coffeeDecorator;
    }

    @Override
    public double getCost() {
        return coffeeDecorator.getCost();
    }
}
