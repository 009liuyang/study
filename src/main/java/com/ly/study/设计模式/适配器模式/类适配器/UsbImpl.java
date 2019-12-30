package com.ly.study.设计模式.适配器模式.类适配器;

/**
 * @Author : ly
 * @Date : 2019-06-03 15:19
 * @description :
 */
public class UsbImpl implements Usb {

    @Override
    public void isUsb() {
        System.out.println("USB口");
    }
}
