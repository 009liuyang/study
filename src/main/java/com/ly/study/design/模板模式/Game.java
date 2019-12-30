package com.ly.study.design.模板模式;

/**
 * @Author : ly
 * @Date : 2019-06-03 14:44
 * @description :
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}