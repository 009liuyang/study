package com.ly.study.algorithm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author : ly
 * @Date : 2019-11-06 17:24
 * @description : 生产者 消费者模式
 */
public class ProducerCostomer {

    public static void main(String[] args) {

        BlockingQueue queue = new ArrayBlockingQueue(100);

        new Thread(() -> {

            for (int i = 0; i <10 ; i++) {

                try {
                    queue.put(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {

            for (int i = 0; i <10 ; i++) {

                try {
                    Object o = queue.take();
                    System.out.println(o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
