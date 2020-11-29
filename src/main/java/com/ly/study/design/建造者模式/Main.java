package com.ly.study.design.建造者模式;

import com.ly.study.design.建造者模式.base.Bike;

public class Main {

    public static void main(String[] args) {
        showBike(new OfoBuilder());
        showBike(new MobikeBuilder());
    }
    private static void showBike(Builder builder) {
        Bike bike = builder.construct();
        bike.getFrame();
        bike.getSeat();
        bike.getTire();
    }
}
