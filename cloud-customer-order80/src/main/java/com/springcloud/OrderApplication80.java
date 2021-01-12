package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动类
 *
 * @author: dxf
 * @date: 2021-01-12 20:49:12
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class OrderApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class, args);
    }
}
