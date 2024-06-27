package com.alipay.cqrsexample.ddd.command;

import com.alipay.cqrsexample.mvc.model.Address;
import com.alipay.cqrsexample.mvc.model.Contact;
import java.util.Set;
import lombok.Data;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:34
 */
@Data
public class UpdateUserCommand {
    private String userId;
    private Set<Address> addresses;
    private Set<Contact> contacts;
}