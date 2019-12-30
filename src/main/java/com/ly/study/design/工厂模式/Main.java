package com.ly.study.design.工厂模式;

/**
 * @Author : ly
 * @Date : 2019-05-23 11:46
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        IEncrypt iEncrypt = Factory.get("MD5");
        iEncrypt.encrypt();
    }
}
