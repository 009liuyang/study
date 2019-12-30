package com.ly.study.设计模式.装饰器模式;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:14
 * @description : 形状装饰器
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape shape;

    public ShapeDecorator(Shape shape){
        this.shape = shape;
    }

    @Override
    public void draw(){
        shape.draw();
    }
}
