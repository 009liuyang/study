package com.ly.study.design.策略模式;

public class Add implements Strategy {

    @Override
    public int calc(int num1, int num2) {
        return num1 + num2;
    }
}
