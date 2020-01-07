package com.ly.study.design.观察者模式;
import java.util.ArrayList;
import java.util.List;

public class MagazineSubject implements Subject{

    //存放订阅者
    private List<Observer> observers = new ArrayList<Observer>();
    //期刊版本
    private int version;


    /**
     * 添加观察者
     * @param obj
     */
    @Override
    public void addObserver(Observer obj) {
        observers.add(obj);
    }

    /**
     * 删除观察者
     * @param obj
     */
    @Override
    public void deleteObserver(Observer obj) {
        int i = observers.indexOf(obj);
        if(i>=0){
            observers.remove(obj);
        }
    }

    /**
     * 通知观察者
     */
    @Override
    public void notifyObserver() {
        for(int i=0; i<observers.size(); i++){
            Observer o = (Observer)observers.get(i);
            o.update(version);
        }
    }

    /**
     * 该杂志发行了新版本
     */
    public void publish(){
        //新版本
        this.version++;
        //信息更新完毕，通知所有观察者
        notifyObserver();
    }
}
