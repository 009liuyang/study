package com.ly.study.reflect;

public class test2 {

    private static final ThreadLocal<String> tl=new ThreadLocal<String>();

    public static void main(String[] args){

        tl.set("main");

        new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set("sub");
            }
        }).start();
    }
}
