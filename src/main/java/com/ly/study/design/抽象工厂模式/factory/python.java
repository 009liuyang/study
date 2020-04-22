package com.ly.study.design.抽象工厂模式.factory;

import com.ly.study.design.抽象工厂模式._python.pythonBook;
import com.ly.study.design.抽象工厂模式._python.pythonVideo;
import com.ly.study.design.抽象工厂模式.book;
import com.ly.study.design.抽象工厂模式.video;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-21
 */
public class python implements factory {
    @Override
    public video getVideo() {
        return new pythonVideo();
    }

    @Override
    public book getBook() {
        return new pythonBook();
    }

}
