package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/19 11:09
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527 {

   public static void main(String[] args) {
        SpringApplication.run(Gateway9527.class,args);
    }
}
