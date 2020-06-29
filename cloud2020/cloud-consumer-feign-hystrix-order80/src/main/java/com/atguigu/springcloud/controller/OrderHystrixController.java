package com.atguigu.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/17 16:23
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable("id") Integer id){
        String reslut=paymentHystrixService.PaymentInfo_ok(id);
        return reslut;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    public String PaymentInfo_timeout(@PathVariable("id") Integer id){
        String reslut=paymentHystrixService.PaymentInfo_timeout(id);
        return reslut;
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池80："+Thread.currentThread().getName()+"8001,id:"+id+"o(╥﹏╥)o~";
    }
    public String payment_Global_FallbackMethod(){
        return "Globalo(╥﹏╥)o";
    }

}
