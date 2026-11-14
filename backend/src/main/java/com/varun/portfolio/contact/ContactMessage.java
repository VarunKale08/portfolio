package com.varun.portfolio.contact;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "contact_message")
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String subject;
    private String message;

    // Filled in by the database (DEFAULT now()), so JPA never writes it.
    @Column(insertable = false, updatable = false)
    private Instant createdAt;

    // Required by JPA
    protected ContactMessage() {
    }

    // Public constructor used by the Service to create a new record
    public ContactMessage(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getSubject() { return subject; }
    public String getMessage() { return message; }
    public Instant getCreatedAt() { return createdAt; }
}