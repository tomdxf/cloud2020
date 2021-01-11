package com.springcloud.dao;

import com.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 付款
 *
 * @author: dxf
 * @date: 2021-01-11 21:37:29
 */
@Mapper
public interface PaymentDao {

    /**
     * 创建
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id获取
     *
     * @param id
     * @return Payment
     */
    Payment getPaymentById(@Param("id") Long id);
}
