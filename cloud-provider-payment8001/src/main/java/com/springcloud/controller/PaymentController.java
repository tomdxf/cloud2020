package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 支付controller
 *
 * @author: dxf
 * @date: 2021-01-11 22:15:40
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);

        return result > 0 ?
                new CommonResult(200, "成功,serverPort: " + serverPort) : new CommonResult(444, "插入失败,serverPort: " + serverPort );
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：" + result);
        return new CommonResult<Payment>(200, "成功,serverPort: " + serverPort, result);
    }

    @GetMapping("/discovery")
    public Object discovery () {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("element: {}", element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("instance: {}\t{}\t{}\t{}", instance.getServiceId(), instance.getHost(),
                    instance.getPort(), instance.getUri());
        }
        
        
        return discoveryClient;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：" + result);
        return new CommonResult<Payment>(200, "成功,serverPort: " + serverPort, result);
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }


}
