package com.ly.study.design.建造者模式;

import com.ly.study.design.建造者模式.base.Bike;
import com.ly.study.design.建造者模式.base.IFrame;
import com.ly.study.design.建造者模式.base.ISeat;
import com.ly.study.design.建造者模式.base.ITire;

public class MobikeBuilder extends Builder {

    private Bike mBike = new Bike();
    @Override
    void buildFrame() {
        mBike.setFrame(new IFrame());
    }
    @Override
    void buildSeat() {
        mBike.setSeat(new ISeat());
    }
    @Override
    void buildTire() {
        mBike.setTire(new ITire());
    }
    @Override
    Bike createBike() {
        return mBike;
    }
}
