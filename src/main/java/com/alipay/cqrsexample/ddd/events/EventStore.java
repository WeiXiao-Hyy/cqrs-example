package com.alipay.cqrsexample.ddd.events;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:44
 */
public class EventStore {
    private final Map<String, List<Event>> store = new HashMap<>();

    public void addEvent(String userId, Event event) {
        store.get(userId).add(event);
    }

    public List<Event> getEvents(String id) {
        return store.getOrDefault(id, Collections.emptyList());
    }
}