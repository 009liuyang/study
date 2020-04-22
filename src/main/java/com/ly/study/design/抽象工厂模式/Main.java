package com.ly.study.design.抽象工厂模式;


import com.ly.study.design.抽象工厂模式.factory.factory;
import com.ly.study.design.抽象工厂模式.factory.javaFactory;

/**
 * @describe
 * @author yang.liu
 * @date 2020-04-21
 */
public class Main {

    public static void main(String[] args) {
        factory factory = new javaFactory();

        video video = factory.getVideo();
        video.produce();

        book book = factory.getBook();
        book.produce();
    }
}
