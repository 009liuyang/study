package com.ly.study.design.适配器模式.类适配器;

/**
 * @Author : ly
 * @Date : 2019-06-03 15:20
 * @description :
 */
public class Adapter extends UsbImpl implements Ps2 {

    @Override
    public void isPs2() {
        isUsb();
    }

}