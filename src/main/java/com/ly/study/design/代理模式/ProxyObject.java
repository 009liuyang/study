package com.ly.study.design.代理模式;

/**
 * @Author : ly
 * @Date : 2019-06-04 17:29
 * @description :
 */
public class ProxyObject extends AbstractObject {

    private RealObject realObject;

    public ProxyObject(RealObject realObject) {
        this.realObject = realObject;
    }

    @Override
    protected void operation() {
        if(realObject == null){
            realObject = new RealObject();
        }

        System.out.println("do something before operation ... ");
        realObject.operation();
        System.out.println("do something after operation ... ");

    }
}
