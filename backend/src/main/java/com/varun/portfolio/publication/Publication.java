package com.varun.portfolio.publication;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String publisher;
    private LocalDate publishedDate;
    private String url;
    private int displayOrder;

    protected Publication() {
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getPublisher() { return publisher; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public String getUrl() { return url; }
    public int getDisplayOrder() { return displayOrder; }
}