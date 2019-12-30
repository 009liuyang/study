package com.ly.study.设计模式.观察者模式.其他版本;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : ly
 * @Date : 2019-06-03 14:39
 * @description :
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();    //状态改变
    public void setMsg(String msg) {
        notifyAll(msg);
    }
    //订阅
    public void addAttach(Observer observer) {
        observers.add(observer);
    }
    //通知所有订阅的观察者
    private void notifyAll(String msg) {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }
}