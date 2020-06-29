package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/16 10:16
 */
@Configuration
public class MyselRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
