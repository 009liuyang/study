package com.ly.study.设计模式.装饰器模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:46
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+ " $" + beverage1.cost());
    }
}
