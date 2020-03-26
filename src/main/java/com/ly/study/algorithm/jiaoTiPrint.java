package com.ly.study.algorithm;

/**
 * @Author : ly
 * @Date : 2019-11-06 14:49
 * @description : 两个线程交替打印
 */
public class jiaoTiPrint {

    public static void main(String[] args) {

        int[] arrA  = {1,2,3,4,5};
        String[] arrB  = {"a","b","c","d","e"};
        Object object = new Object();

        new Thread(() -> {

            synchronized (object){

                for (int x : arrA) {
                    System.out.println(x);

                    try {
                        object.wait();
                        object.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(() -> {

            synchronized (object){

                for (String x : arrB) {
                    System.out.println(x);

                    try {
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
