package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/10 17:56
 */
@Configuration
public class ApplicationContextConfig {
    @Bean

    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
