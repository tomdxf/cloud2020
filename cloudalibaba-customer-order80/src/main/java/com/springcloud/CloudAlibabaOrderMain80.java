package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description： 主启动
 * @author: DXF
 * @date: 2021-10-05 14:33:26
 * @version: 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class CloudAlibabaOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaOrderMain80.class,args);
    }
}
