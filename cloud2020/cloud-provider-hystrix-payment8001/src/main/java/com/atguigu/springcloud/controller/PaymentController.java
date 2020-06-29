package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/17 14:25
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id){
        String result= paymentService.paymentInfo_ok(id);
        log.info("result:"+result);
        return result;
    }
    @GetMapping("payment/hystrix/timeout/{id}")
    public String PaymentInfo_timeout(@PathVariable("id") Integer id){
        String result= paymentService.paymentInfo_timeout(id);
        log.info("result:"+result);
        return result;
    }
@GetMapping("payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")  Integer id){
        String result=paymentService.paymentCircuitBreaker(id);
        return result;
}
}
