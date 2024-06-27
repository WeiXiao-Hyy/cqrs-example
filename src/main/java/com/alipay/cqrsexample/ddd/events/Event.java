package com.alipay.cqrsexample.ddd.events;

import java.util.Date;
import java.util.UUID;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 22:33
 */
public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final Date created = new Date();
}