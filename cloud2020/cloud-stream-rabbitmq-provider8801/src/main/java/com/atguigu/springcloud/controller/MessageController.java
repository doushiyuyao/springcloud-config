package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/28 15:55
 */
@RestController
public class MessageController {
    @Autowired
    private IMessageProvider iMessageProvider;
    @GetMapping(value="/sendMessage")
    public  String SendMessage(){
        return iMessageProvider.sendMessage();
    }
}
