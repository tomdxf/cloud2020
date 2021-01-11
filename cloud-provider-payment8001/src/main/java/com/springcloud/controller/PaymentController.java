package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: dxf
 * @date: 2021-01-11 22:15:40
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    
    @Resource
    private PaymentService paymentService;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：{}", result);

        return result > 0 ?
                new CommonResult(200, "成功") : new CommonResult(444, "插入失败");
    }

    @GetMapping("getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Long id) {
        Payment result = paymentService.getPaymentById(id);

        return new CommonResult<Payment>(200, "成功", result);
    }
}
