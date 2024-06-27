package com.alipay.cqrsexample.ddd.events;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:40
 */

@Getter
@Setter
public class UserAddressRemovedEvent extends Event {
    private String city;
    private String state;
    private String postCode;

    public UserAddressRemovedEvent(String city, String state, String postCode) {
        super();
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }
}