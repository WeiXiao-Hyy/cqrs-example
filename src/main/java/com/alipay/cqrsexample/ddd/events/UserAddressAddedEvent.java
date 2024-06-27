package com.alipay.cqrsexample.ddd.events;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:39
 */
@Setter
@Getter
public class UserAddressAddedEvent extends Event {
    private String city;
    private String state;
    private String postCode;

    public UserAddressAddedEvent(String city, String state, String postCode) {
        super();
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }
}