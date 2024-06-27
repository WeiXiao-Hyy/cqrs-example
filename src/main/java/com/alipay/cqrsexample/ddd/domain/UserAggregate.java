package com.alipay.cqrsexample.ddd.domain;

import com.alipay.cqrsexample.ddd.command.CreateUserCommand;
import com.alipay.cqrsexample.ddd.command.UpdateUserCommand;
import com.alipay.cqrsexample.ddd.events.Event;
import com.alipay.cqrsexample.ddd.events.EventStore;
import com.alipay.cqrsexample.ddd.events.UserContactAddedEvent;
import com.alipay.cqrsexample.ddd.events.UserContactRemovedEvent;
import com.alipay.cqrsexample.ddd.events.UserCreatedEvent;
import com.alipay.cqrsexample.ddd.service.UserUtility;
import com.alipay.cqrsexample.mvc.model.Contact;
import com.alipay.cqrsexample.mvc.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 * @Description
 * @create 2024-06-27 21:35
 */

public class UserAggregate {
    private EventStore writeRepository;

    public UserAggregate(EventStore repository) {
        this.writeRepository = repository;
    }

    public List<Event> handleCreateUserCommand(CreateUserCommand command) {
        UserCreatedEvent event = new UserCreatedEvent(command.getUserId(),
                command.getFirstName(), command.getLastName());
        writeRepository.addEvent(command.getUserId(), event);
        return List.of(event);
    }

    public List<Event> handleUpdateUserCommand(UpdateUserCommand command) {
        User user = UserUtility.recreateUserState(writeRepository, command.getUserId());
        List<Event> events = new ArrayList<>();

        List<Contact> contactsToRemove = user.getContacts().stream()
                .filter(c -> !command.getContacts().contains(c))
                .toList();
        for (Contact contact : contactsToRemove) {
            UserContactRemovedEvent contactRemovedEvent = new UserContactRemovedEvent(contact.getType(),
                    contact.getDetail());
            events.add(contactRemovedEvent);
            writeRepository.addEvent(command.getUserId(), contactRemovedEvent);
        }
        List<Contact> contactsToAdd = command.getContacts().stream()
                .filter(c -> !user.getContacts().contains(c))
                .toList();
        for (Contact contact : contactsToAdd) {
            UserContactAddedEvent contactAddedEvent = new UserContactAddedEvent(contact.getType(),
                    contact.getDetail());
            events.add(contactAddedEvent);
            writeRepository.addEvent(command.getUserId(), contactAddedEvent);
        }

        // similarly process addressesToRemove
        // similarly process addressesToAdd

        return events;
    }

}