package com.alipay.cqrsexample.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String state;
    private String postcode;
}