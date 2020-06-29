package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/15 10:27
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/payment/consul")
    public String paymentconsul(){
        return "consul:"+serverPort+ UUID.randomUUID().toString();
    }
}
