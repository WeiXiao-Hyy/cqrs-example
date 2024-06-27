package com.alipay.cqrsexample.ddd.events;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:36
 */
@Setter
@Getter
public class UserContactAddedEvent extends Event {
    private String contactType;
    private String contactDetails;

    public UserContactAddedEvent(String contactType, String contactDetails) {
        super();
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }
}