package com.ly.study.设计模式.策略模式;

/**
 * @Author : ly
 * @Date : 2019-05-23 11:33
 * @description :
 */
public class MD5Encrypt implements IEncrypt {

    @Override
    public void encrypt() {
        System.out.println("执行MD5加密");
    }
}
