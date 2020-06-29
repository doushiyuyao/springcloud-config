package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/28 16:08
 */
@Component
@EnableBinding(Sink.class)

public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String servicePort;
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("1"+message.getPayload()+servicePort);
    }
}
