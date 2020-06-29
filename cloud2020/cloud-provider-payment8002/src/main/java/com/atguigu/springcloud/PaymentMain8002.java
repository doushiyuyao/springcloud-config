package com.atguigu.springcloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/10 13:57
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.atguigu.springcloud.dao")
@EnableDiscoveryClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
