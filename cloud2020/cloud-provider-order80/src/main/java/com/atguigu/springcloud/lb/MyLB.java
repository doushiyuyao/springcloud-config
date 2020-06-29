package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/16 14:51
 */
@Component
public class MyLB implements LoadBalancer{

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        return null;
    }
}
