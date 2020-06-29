package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeign;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/16 16:46
 */
@RestController
public class OrderFeigne {
    @Autowired
    private PaymentFeign paymentFeign;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value="consumer/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeign.getPayment(id);
    }
    @GetMapping(value="consumer/payment/feign/timeout")
    public String paymentFeignTimeout() throws InterruptedException {
        return paymentFeign.paymentFeignTimeout();
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentzipkin(){
        String result=restTemplate.getForObject("http://127.0.0.1:8001/"+"/payment/zipkin/",String.class);
        return result;
    }
}
