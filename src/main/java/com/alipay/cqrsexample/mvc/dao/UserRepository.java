package com.alipay.cqrsexample.mvc.dao;

import com.alipay.cqrsexample.mvc.model.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:18
 */
@Repository
public class UserRepository {
    private final Map<String, User> store = new HashMap<>();

    public User getUser(String userId) {
        return store.getOrDefault(userId, null);
    }

    public void addUser(String userId, User user) {
        store.put(userId, user);
    }
}