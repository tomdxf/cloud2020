package com.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * payment实体
 * @author dxf
 * @date 2021-1-11 21:21:41
 * */
@Data
public class Payment implements Serializable {

    /**
     * 主键id
     */
    private Long id;
    /**
     *
     */
    private String serial;

    public Payment(long id, String serial) {
        this.id = id;
        this.serial = serial;
    }
}
