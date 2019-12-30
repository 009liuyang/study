package com.ly.study.design.代理模式;

/**
 * @Author : ly
 * @Date : 2019-06-04 17:29
 * @description :
 */
public class RealObject extends AbstractObject {

    @Override
    protected void operation() {
        System.out.println("do  RealObject ...");
    }
}
