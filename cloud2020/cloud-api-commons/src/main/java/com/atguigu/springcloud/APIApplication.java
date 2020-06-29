package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/10 17:04
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class APIApplication {
    public static void main(String[] args) {
        SpringApplication.run(APIApplication.class,args);
    }
}
