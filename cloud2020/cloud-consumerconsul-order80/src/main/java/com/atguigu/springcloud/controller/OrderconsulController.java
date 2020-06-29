package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/15 10:55
 */
@RestController
public class OrderconsulController {
    public static final String PAYMENT_URL="http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/consul/zk")
    public String getPayment(){
         String result=restTemplate.getForObject(PAYMENT_URL+"/payment/get/",String.class);
        return result;
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentzipkin(){
        String result=restTemplate.getForObject("http://127.0.0.1:8001/"+"/payment/zipkin/",String.class);
        return result;
    }

}
