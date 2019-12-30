package com.ly.study.设计模式.观察者模式;

/**
 * @Author : ly
 * @Date : 2019-05-31 18:54
 * @description :
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
