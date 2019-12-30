package com.ly.study.design.观察者模式;

/**
 * @Author : ly
 * @Date : 2019-05-31 18:53
 * @description :
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
