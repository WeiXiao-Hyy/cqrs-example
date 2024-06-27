package com.alipay.cqrsexample.ddd.service;

import com.alipay.cqrsexample.ddd.events.Event;
import com.alipay.cqrsexample.ddd.events.EventStore;
import com.alipay.cqrsexample.ddd.events.UserAddressAddedEvent;
import com.alipay.cqrsexample.ddd.events.UserAddressRemovedEvent;
import com.alipay.cqrsexample.ddd.events.UserContactAddedEvent;
import com.alipay.cqrsexample.ddd.events.UserContactRemovedEvent;
import com.alipay.cqrsexample.ddd.events.UserCreatedEvent;
import com.alipay.cqrsexample.mvc.model.Address;
import com.alipay.cqrsexample.mvc.model.Contact;
import com.alipay.cqrsexample.mvc.model.User;
import java.util.List;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 23:05
 */
public class UserUtility {

    public static User recreateUserState(EventStore store, String userId) {
        User user = null;

        List<Event> events = store.getEvents(userId);
        for (Event event : events) {
            if (event instanceof UserCreatedEvent) {
                UserCreatedEvent e = (UserCreatedEvent) event;
                user = new User(e.getUserId(), e.getFirstName(), e.getLastName());
            }
            if (event instanceof UserAddressAddedEvent) {
                UserAddressAddedEvent e = (UserAddressAddedEvent) event;
                Address address = new Address(e.getCity(), e.getState(), e.getPostCode());
                if (user != null)
                    user.getAddresses()
                            .add(address);
            }
            if (event instanceof UserAddressRemovedEvent) {
                UserAddressRemovedEvent e = (UserAddressRemovedEvent) event;
                Address address = new Address(e.getCity(), e.getState(), e.getPostCode());
                if (user != null)
                    user.getAddresses()
                            .remove(address);
            }
            if (event instanceof UserContactAddedEvent) {
                UserContactAddedEvent e = (UserContactAddedEvent) event;
                Contact contact = new Contact(e.getContactType(), e.getContactDetails());
                if (user != null)
                    user.getContacts()
                            .add(contact);
            }
            if (event instanceof UserContactRemovedEvent) {
                UserContactRemovedEvent e = (UserContactRemovedEvent) event;
                Contact contact = new Contact(e.getContactType(), e.getContactDetails());
                if (user != null)
                    user.getContacts()
                            .remove(contact);
            }
        }

        return user;
    }

}