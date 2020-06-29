package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/10 14:26
 */
@Mapper
public interface PaymentDao {
    //create
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
