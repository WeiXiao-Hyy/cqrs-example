package com.alipay.cqrsexample.ddd.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressByRegionQuery {
    private String userId;
    private String state;
}