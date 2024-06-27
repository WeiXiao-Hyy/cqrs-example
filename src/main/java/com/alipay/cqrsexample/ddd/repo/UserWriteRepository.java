package com.alipay.cqrsexample.ddd.repo;

import com.alipay.cqrsexample.mvc.model.User;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:36
 */
public class UserWriteRepository {
    private Map<String, User> store = new HashMap<>();
    // accessors and mutators

    public User getUser(String userId) {
        return store.getOrDefault(userId, null);
    }

    public void addUser(String userId, User user) {
        store.put(userId, user);
    }
}