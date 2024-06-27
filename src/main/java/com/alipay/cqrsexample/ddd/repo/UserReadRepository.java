package com.alipay.cqrsexample.ddd.repo;

import com.alipay.cqrsexample.ddd.domain.UserAddress;
import com.alipay.cqrsexample.ddd.domain.UserContact;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:49
 */
public class UserReadRepository {
    private final Map<String, UserAddress> userAddresses = new HashMap<>();
    private final Map<String, UserContact> userContacts = new HashMap<>();

    public UserContact getUserContact(String userId) {
        return userContacts.get(userId);
    }

    public UserAddress getUserAddress(String userId) {
        return userAddresses.get(userId);
    }

    public void addUserContact(String userId, UserContact userContact) {
        userContacts.put(userId, userContact);
    }

    public void addUserAddress(String userId, UserAddress userAddress) {
        userAddresses.put(userId, userAddress);
    }
}