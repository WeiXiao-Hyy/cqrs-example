package com.alipay.cqrsexample.ddd.domain;

import com.alipay.cqrsexample.mvc.model.Address;
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
public class UserAddress {
    private Map<String, Set<Address>> addressByRegion = new HashMap<>();
}