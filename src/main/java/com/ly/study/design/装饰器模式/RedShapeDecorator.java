package com.ly.study.design.装饰器模式;

/**
 * @Author : ly
 * @Date : 2019-06-13 19:16
 * @description : 红色形状装饰器
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
