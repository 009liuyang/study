package com.ly.study.design.抽象工厂模式._python;

import com.ly.study.design.抽象工厂模式.book;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-21
 */
public class pythonBook extends book {
    @Override
    protected void produce() {
        System.out.println("produce pythonBook");
    }
}
