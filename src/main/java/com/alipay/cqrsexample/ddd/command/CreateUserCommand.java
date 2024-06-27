package com.alipay.cqrsexample.ddd.command;

import lombok.Data;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:23
 */
@Data
public class CreateUserCommand {
    private String userId;
    private String firstName;
    private String lastName;
}