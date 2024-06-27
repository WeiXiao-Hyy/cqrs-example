package com.alipay.cqrsexample.ddd.events;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:34
 */
@Setter
@Getter
public class UserCreatedEvent extends Event {
    private String userId;
    private String firstName;
    private String lastName;

    public UserCreatedEvent(String userId, String firstName, String lastName) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}