package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/28 15:46
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderServiceImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;
    @Override
    public String sendMessage() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
        return null;
    }
}
