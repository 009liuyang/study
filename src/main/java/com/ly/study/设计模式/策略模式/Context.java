package com.ly.study.设计模式.策略模式;

/**
 * @Author : ly
 * @Date : 2019-05-23 11:34
 * @description :
 */
public class Context {

    private IEncrypt strategy;

    public Context(IEncrypt strategy){
        this.strategy = strategy;
    }

    public void encrypt(){
        this.strategy.encrypt();
    }

}
