package com.ly.study.design.装饰器模式;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:13
 * @description : 矩形
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }

}
