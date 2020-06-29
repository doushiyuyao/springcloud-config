package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/18 9:31
 */
@Component
public class PaymentFallbackService implements  PaymentHystrixService {
    @Override
    public String PaymentInfo_ok(Integer id) {
        return "ok:1";
    }

    @Override
    public String PaymentInfo_timeout(Integer id) {
        return "timeout:2";
    }
}
