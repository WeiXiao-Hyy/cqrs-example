package com.alipay.cqrsexample.ddd.query;

import lombok.Data;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:50
 */
@Data
public class AddressByRegionQuery {
    private String userId;
    private String state;
}