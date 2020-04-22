package com.ly.study.design.抽象工厂模式.factory;

import com.ly.study.design.抽象工厂模式._java.javaBook;
import com.ly.study.design.抽象工厂模式._java.javaVideo;
import com.ly.study.design.抽象工厂模式.book;
import com.ly.study.design.抽象工厂模式.video;

/**
 * @describe
 * @author yang.liu
 * @date 2020-04-21
 */
public class javaFactory implements factory {
    @Override
    public video getVideo() {
        return new javaVideo();
    }

    @Override
    public book getBook() {
        return new javaBook();
    }

}
