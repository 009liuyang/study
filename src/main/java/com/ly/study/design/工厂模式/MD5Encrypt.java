package com.ly.study.design.工厂模式;

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
