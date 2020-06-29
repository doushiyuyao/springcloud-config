package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/16 16:38
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeign {
    @GetMapping(value="payment/get/{id}")
    CommonResult<Payment>  getPayment(@PathVariable("id") Long id);
    @GetMapping(value="payment/feign/timeout")
    public String paymentFeignTimeout() ;
}
