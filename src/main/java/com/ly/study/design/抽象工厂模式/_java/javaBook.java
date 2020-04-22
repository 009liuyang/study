package com.ly.study.design.抽象工厂模式._java;

import com.ly.study.design.抽象工厂模式.book;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-21
 */
public class javaBook extends book {
    @Override
    protected void produce() {
        System.out.println("product javaBook");
    }
}
