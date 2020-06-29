package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/10 14:57
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
