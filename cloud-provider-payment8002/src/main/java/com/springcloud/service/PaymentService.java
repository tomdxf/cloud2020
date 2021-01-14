package com.springcloud.service;

import com.springcloud.entities.Payment;

/**
 * 支付
 *
 * @author: dxf
 * @date: 2021-01-11 22:08:19
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
