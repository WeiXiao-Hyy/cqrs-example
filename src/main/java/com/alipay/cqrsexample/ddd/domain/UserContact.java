package com.alipay.cqrsexample.ddd.domain;

import com.alipay.cqrsexample.mvc.model.Contact;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.Data;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:41
 */
@Data
public class UserContact {
    private Map<String, Set<Contact>> contactByType = new HashMap<>();
}