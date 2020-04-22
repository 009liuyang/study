package com.ly.study.design.抽象工厂模式._java;

import com.ly.study.design.抽象工厂模式.video;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-21
 */
public class javaVideo extends video {

    @Override
    protected void produce() {
        System.out.println("produce javaVideo");
    }
}
