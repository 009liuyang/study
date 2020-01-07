package com.ly.study.design.观察者模式;

/**
 * 观察者接口
 */
public interface Observer {

    //当主题状态改变时,更新通知
    public void update(int version);
}
