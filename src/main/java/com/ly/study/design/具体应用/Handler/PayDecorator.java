package com.ly.study.design.具体应用.Handler;

import com.ly.study.design.具体应用.PayService;

public class PayDecorator implements PayService{

    private PayService payService;

    public PayDecorator(PayService payService){
        this.payService = payService;
    }

    @Override
    public void pcPay() {
        System.out.println("支付前 计算手续费");
        payService.pcPay();
    }

    @Override
    public void h5pay() {
    }
}
