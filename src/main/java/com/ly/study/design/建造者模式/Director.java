package com.ly.study.design.建造者模式;

import com.ly.study.design.建造者模式.base.Bike;

public class Director {

    private Builder mBuilder = null;
    public Director(Builder builder) {
        mBuilder = builder;
    }
    public Bike construct() {
        mBuilder.buildFrame();
        mBuilder.buildSeat();
        mBuilder.buildTire();
        return mBuilder.createBike();
    }
}
