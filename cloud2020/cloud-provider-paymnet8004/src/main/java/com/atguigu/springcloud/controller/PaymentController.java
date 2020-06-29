package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/12 15:58
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
   @RequestMapping(value="/payment/zk")
   public String paymentzk(){
       return "zookeeper:"+serverPort+ UUID.randomUUID().toString();
   }
}
