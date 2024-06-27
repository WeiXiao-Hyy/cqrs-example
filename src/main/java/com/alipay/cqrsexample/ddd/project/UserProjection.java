package com.alipay.cqrsexample.ddd.project;

import com.alipay.cqrsexample.ddd.domain.UserAddress;
import com.alipay.cqrsexample.ddd.domain.UserContact;
import com.alipay.cqrsexample.ddd.query.AddressByRegionQuery;
import com.alipay.cqrsexample.ddd.query.ContactByTypeQuery;
import com.alipay.cqrsexample.ddd.repo.UserReadRepository;
import com.alipay.cqrsexample.mvc.model.Address;
import com.alipay.cqrsexample.mvc.model.Contact;
import java.util.Set;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:52
 */
public class UserProjection {
    private final UserReadRepository readRepository;

    public UserProjection(UserReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    public Set<Contact> handle(ContactByTypeQuery query) {
        UserContact userContact = readRepository.getUserContact(query.getUserId());
        return userContact.getContactByType()
                .get(query.getContactType());
    }

    public Set<Address> handle(AddressByRegionQuery query) {
        UserAddress userAddress = readRepository.getUserAddress(query.getUserId());
        return userAddress.getAddressByRegion()
                .get(query.getState());
    }
}