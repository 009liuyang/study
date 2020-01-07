package com.ly.study.design.具体应用;

import com.ly.study.design.具体应用.Handler.PayDecorator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @PostMapping("/pay")
    public String pay(String payType) throws Exception{

       PayService service = PayTypeEnum.getPayType(payType);

       PayDecorator payDecorator = new PayDecorator(service);
       payDecorator.pcPay();

       return "SUCCESS";
    }

}
