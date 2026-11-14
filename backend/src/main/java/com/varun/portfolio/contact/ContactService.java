package com.varun.portfolio.contact;

import com.varun.portfolio.contact.dto.ContactRequest;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactMessageRepository repository;
    private final ContactNotifier notifier;

    // 1. Inject ContactNotifier through the constructor, next to the repository.
    public ContactService(ContactMessageRepository repository, ContactNotifier notifier) {
        this.repository = repository;
        this.notifier = notifier;
    }

    // 3. Removed @Transactional
    public void submit(ContactRequest request) {
        ContactMessage message = new ContactMessage(
                request.name(),
                request.email(),
                request.subject(),
                request.message()
        );

        // Save to database first
        repository.save(message);

        // 2. Call the notifier AFTER saving
        notifier.notifyNewMessage(request);
    }
}