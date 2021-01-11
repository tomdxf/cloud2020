package com.springcloud.entities;

import lombok.Data;

/**
 * 公共响应参数
 *
 * @author: dxf
 * @date: 2021-01-11 21:30:48
 */
@Data
public class CommonResult<T> {
    /**
     * 响应码
     * */
    private Integer code;
    /**
     * 响应信息
     * */
    private String message;
    /**
     * 数据
     * */
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
