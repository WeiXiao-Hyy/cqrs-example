package com.alipay.cqrsexample.ddd.events;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:39
 */

@Getter
@Setter
public class UserContactRemovedEvent extends Event {
    private String contactType;
    private String contactDetails;

    public UserContactRemovedEvent(String contactType, String contactDetails) {
        super();
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }
}