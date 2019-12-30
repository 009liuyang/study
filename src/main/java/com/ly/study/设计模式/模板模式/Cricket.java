package com.ly.study.设计模式.模板模式;

/**
 * @Author : ly
 * @Date : 2019-06-03 14:44
 * @description :
 */
public class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}