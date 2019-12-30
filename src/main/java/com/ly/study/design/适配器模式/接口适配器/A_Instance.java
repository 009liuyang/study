package com.ly.study.design.适配器模式.接口适配器;

/**
 * @Author : ly
 * @Date : 2019-06-03 15:17
 * @description :
 */
public class A_Instance extends Adapter {

    public void a(){
        System.out.println("实现A方法被调用");
    }
    public void d(){
        System.out.println("实现d方法被调用");
    }
}
