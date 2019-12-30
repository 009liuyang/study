package com.ly.study.design.观察者模式;

/**
 * @Author : ly
 * @Date : 2019-05-31 18:54
 * @description :
 */
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}