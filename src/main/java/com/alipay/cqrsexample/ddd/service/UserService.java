package com.alipay.cqrsexample.ddd.service;

import com.alipay.cqrsexample.ddd.events.EventStore;
import com.alipay.cqrsexample.ddd.events.UserAddressAddedEvent;
import com.alipay.cqrsexample.ddd.events.UserAddressRemovedEvent;
import com.alipay.cqrsexample.ddd.events.UserContactAddedEvent;
import com.alipay.cqrsexample.ddd.events.UserContactRemovedEvent;
import com.alipay.cqrsexample.ddd.events.UserCreatedEvent;
import com.alipay.cqrsexample.mvc.model.Address;
import com.alipay.cqrsexample.mvc.model.Contact;
import com.alipay.cqrsexample.mvc.model.User;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:46
 */
public class UserService {
    private final EventStore eventStore;

    public UserService(EventStore repository) {
        this.eventStore = repository;
    }

    public void createUser(String userId, String firstName, String lastName) {
        eventStore.addEvent(userId, new UserCreatedEvent(userId, firstName, lastName));
    }

    public void updateUser(String userId, Set<Contact> contacts, Set<Address> addresses) {
        User user = UserUtility.recreateUserState(eventStore, userId);
        user.getContacts().stream()
                .filter(c -> !contacts.contains(c))
                .forEach(c -> eventStore.addEvent(
                        userId, new UserContactRemovedEvent(c.getType(), c.getDetail())));
        contacts.stream()
                .filter(c -> !user.getContacts().contains(c))
                .forEach(c -> eventStore.addEvent(
                        userId, new UserContactAddedEvent(c.getType(), c.getDetail())));
        user.getAddresses().stream()
                .filter(a -> !addresses.contains(a))
                .forEach(a -> eventStore.addEvent(
                        userId, new UserAddressRemovedEvent(a.getCity(), a.getState(), a.getPostcode())));
        addresses.stream()
                .filter(a -> !user.getAddresses().contains(a))
                .forEach(a -> eventStore.addEvent(
                        userId, new UserAddressAddedEvent(a.getCity(), a.getState(), a.getPostcode())));
    }

    public Set<Contact> getContactByType(String userId, String contactType) {
        User user = UserUtility.recreateUserState(eventStore, userId);
        return user.getContacts().stream()
                .filter(c -> c.getType().equals(contactType))
                .collect(Collectors.toSet());
    }

    public Set<Address> getAddressByRegion(String userId, String state) throws Exception {
        User user = UserUtility.recreateUserState(eventStore, userId);
        return user.getAddresses().stream()
                .filter(a -> a.getState().equals(state))
                .collect(Collectors.toSet());
    }
}