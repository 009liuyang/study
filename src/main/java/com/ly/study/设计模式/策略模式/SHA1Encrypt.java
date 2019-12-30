package com.ly.study.设计模式.策略模式;

/**
 * @Author : ly
 * @Date : 2019-05-23 11:34
 * @description :
 */
public class SHA1Encrypt implements IEncrypt {

    @Override
    public void encrypt() {
        System.out.println("执行SHA1加密");
    }

}
