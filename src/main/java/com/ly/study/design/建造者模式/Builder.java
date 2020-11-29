package com.ly.study.design.建造者模式;

import com.ly.study.design.建造者模式.base.Bike;

public abstract class Builder {

    abstract void buildFrame();
    abstract void buildSeat();
    abstract void buildTire();
    abstract Bike createBike();

    /**
     * 把导演类中的construct()方法合并到抽象建造者类中
     *
     * @return 具体产品对象
     */
    public Bike construct() {
        this.buildFrame();
        this.buildSeat();
        this.buildTire();
        return this.createBike();
    }
}
