package com.alipay.cqrsexample.mvc.model;

import lombok.Data;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:16
 */
@Data
public class Contact {
    private String type;
    private String detail;
}