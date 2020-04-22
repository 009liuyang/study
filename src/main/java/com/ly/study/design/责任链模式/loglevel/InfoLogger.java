package com.ly.study.design.责任链模式.loglevel;

import com.ly.study.design.责任链模式.AbstractLogger;

/**
 * @author yang.liu
 * @describe
 * @date 2020-04-22
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info : " + message);
    }
}
