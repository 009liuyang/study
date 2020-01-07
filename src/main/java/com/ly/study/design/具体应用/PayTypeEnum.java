package com.ly.study.design.具体应用;


public enum PayTypeEnum {

    ALIPAY("com.ly.study.design.具体应用.Serivce.AlipayServiceImpl"),
    WECHAT("com.ly.study.design.具体应用.Serivce.WechatServiceImpl");

    private String className;

    PayTypeEnum(String className){
        this.className = className;
    }

    public static PayService getPayType(String payType) throws Exception {
        for (PayTypeEnum type : values()){
            if(type.name().equals(payType)){
                return (PayService)Class.forName(type.className).newInstance();
            }
        }
        return null;
    }
}
