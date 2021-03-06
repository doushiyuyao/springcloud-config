package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/29 16:15
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${server-url.nacos-user-service}")
    private  String serverUrl;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
    }
}
