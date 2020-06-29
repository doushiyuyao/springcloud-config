package com.atguigu.springcloudAlibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/29 15:54
 */
@RestController
public class PaymnetController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "/payment/nacos/{id}")
    public String getpayment(@PathVariable("id") Integer id){
        return serverPort;
    }
}
