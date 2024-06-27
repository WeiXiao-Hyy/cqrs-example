package com.alipay.cqrsexample.mvc.model;

import lombok.Data;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:16
 */
@Data
public class Address {
    private String city;
    private String state;
    private String postcode;
}