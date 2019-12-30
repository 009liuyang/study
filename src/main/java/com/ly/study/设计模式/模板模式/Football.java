package com.ly.study.设计模式.模板模式;

/**
 * @Author : ly
 * @Date : 2019-06-03 14:45
 * @description :
 */
public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}