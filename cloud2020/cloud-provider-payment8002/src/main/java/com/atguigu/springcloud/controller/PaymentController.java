package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
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

    @RequestMapping(value="/payment/zk")
    public String paymentzk(){
        return "zookeeper:"+serverPort+ UUID.randomUUID().toString();
    }
   /* @Resource
    private DataSource datasource;
    @Bean
    public SqlSessionFactory sqlSessionFactory()throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        return sqlSessionFactoryBean.getObject();
    }*/
   @GetMapping(value="/payment/lb")
   public String getPayment(){
       return serverPort;
   }
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
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        return new CommonResult(200,"查询成功"+serverPort);
    }
    @GetMapping(value="payment/feign/timeout")
    public String paymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }
}
