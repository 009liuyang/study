package com.ly.study.design.抽象工厂模式.factory;

import com.ly.study.design.抽象工厂模式.book;
import com.ly.study.design.抽象工厂模式.video;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-21
 */
public interface factory {

    video getVideo();

    book getBook();
}
