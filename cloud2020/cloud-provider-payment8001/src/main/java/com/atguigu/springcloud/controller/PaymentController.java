package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 *
 * @Author: dsy
 * @Date: 2020/6/10 15:06
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
   /* @Resource
    private DataSource datasource;
    @Bean
    public SqlSessionFactory sqlSessionFactory()throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        return sqlSessionFactoryBean.getObject();
    }*/

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
       int result= paymentService.create(payment);
       log.info("******"+result);
       if(result>0){
           return new CommonResult(200,"插入数据库成功"+serverPort,result);
       }else{
           return new CommonResult(400,"插入数据库失败",null);
       }
    }
    @GetMapping(value="/payment/lb")
    public String getPayment(){
        return serverPort;
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        log.info("log:{}",id);
        return new CommonResult(200,"查询成功"+serverPort);
        /*Payment payment= paymentService.getPaymentById(id);
        if(payment!=null){

        }else{
            return new CommonResult(400,"查询数据库失败"+id,null);
        }*/
    }
    @GetMapping(value="/payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for(String element: services){
            log.info("eee"+element);
        }
       List<ServiceInstance> instances= discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance  instance: instances){
            log.info(instance.getServiceId()+"\t"+instance.getPort());
        }
        return this.discoveryClient;
    }
    @GetMapping(value="payment/feign/timeout")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }


    @GetMapping(value = "/payment/zipkin")
    public String paymentzipkin(){
        return "hi";}
}
