package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/24 10:18
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMian3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMian3366.class,args);
    }
}
