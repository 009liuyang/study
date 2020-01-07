package com.ly.study.design.装饰器模式;

/**
 * 装饰器
 */
public class HouseDecorator implements House {

    private House houseDecorator;

    public HouseDecorator(House houseDecorator) {
        this.houseDecorator = houseDecorator;
    }

    @Override
    public void output() {
        System.out.println("装修房子");
        houseDecorator.output();
        System.out.println("入住房子");
    }
}
