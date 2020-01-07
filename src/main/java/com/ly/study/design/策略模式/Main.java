package com.ly.study.design.策略模式;

public class Main {

    public static void main(String[] args) {

        Context contextAdd = new Context(new Add());
        int addResult = contextAdd.executeStrategy(1,2);
        System.out.println(addResult);

        Context contextSub = new Context(new Substract());
        int subResult = contextSub.executeStrategy(2,3);
        System.out.println(subResult);

    }
}
