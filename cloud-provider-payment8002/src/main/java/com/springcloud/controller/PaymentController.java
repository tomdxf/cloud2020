package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.springcloud.service.PaymentService;

import javax.annotation.Resource;

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

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);

        return result > 0 ?
                new CommonResult(200, "成功,serverPort: " + serverPort) : new CommonResult(444, "插入失败,serverPort: " + serverPort);
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("查询结果：" + result);
        return new CommonResult<Payment>(200, "成功,serverPort: " + serverPort, result);
    }
}
