package com.ly.study.design.具体应用.Serivce;

import com.ly.study.design.具体应用.PayService;

public abstract class AbstractPayService implements PayService {

    @Override
    public void pcPay() {
        pay();
    }

    @Override
    public void h5pay() {

    }

    public abstract void pay();

}
