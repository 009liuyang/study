package com.ly.study.design.观察者模式.其他版本;

/**
 * @Author : ly
 * @Date : 2019-06-03 14:39
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        F_Observer fObserver = new F_Observer();
        S_Observer sObserver = new S_Observer();
        T_Observer tObserver = new T_Observer();
        Subject subject = new Subject();
        subject.addAttach(fObserver);
        subject.addAttach(sObserver);
        subject.addAttach(tObserver);
        subject.setMsg("msg change");
    }
}
