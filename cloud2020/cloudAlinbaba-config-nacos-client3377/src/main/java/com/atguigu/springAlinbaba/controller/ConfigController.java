package com.atguigu.springAlinbaba.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/29 17:35
 */
@RestController
@Slf4j
@RefreshScope  //支持nacos的动态刷新
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/config/info")
    public String getConfigInfo(){
        return  configInfo;
    }

}
