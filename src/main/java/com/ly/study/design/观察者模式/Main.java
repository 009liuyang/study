package com.ly.study.design.观察者模式;

/**
 * 订阅、发布模式
 * 当主题更新后，会通知注册在它身上的被观察者
 */
public class Main {

    public static void main(String[] args) {

        //step1: 创建主题(被观察者)
        MagazineSubject magazine = new MagazineSubject();

        //step2: 创建三个不同的观察者
        CustomerObserver a = new CustomerObserver("A");
        CustomerObserver b = new CustomerObserver("B");
        CustomerObserver c = new CustomerObserver("C");

        //step3: 将观察者注册到主题中
        magazine.addObserver(a);
        magazine.addObserver(b);
        magazine.addObserver(c);

        //更新主题的数据，当数据更新后，会自动通知所有已注册的观察者
        magazine.publish();
    }
}
