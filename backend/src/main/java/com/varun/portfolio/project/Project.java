package com.varun.portfolio.project;

//package com.varun.portfolio.project;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;
    private String title;
    private String summary;
    private String description;
    private String imageUrl;
    private String githubUrl;
    private String liveUrl;
    private boolean featured;
    private int displayOrder;

    // Filled in by the database (DEFAULT now()), so JPA never writes it.
    @Column(insertable = false, updatable = false)
    private Instant createdAt;

    // The tech tags live in the project_tech table, one row per tag.
    @ElementCollection
    @CollectionTable(name = "project_tech", joinColumns = @JoinColumn(name = "project_id"))
    @OrderColumn(name = "position")
    @Column(name = "name")
    private List<String> techStack = new ArrayList<>();

    // JPA needs a no-argument constructor.
    protected Project() {
    }

    public Long getId() { return id; }
    public String getSlug() { return slug; }
    public String getTitle() { return title; }
    public String getSummary() { return summary; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public String getGithubUrl() { return githubUrl; }
    public String getLiveUrl() { return liveUrl; }
    public boolean isFeatured() { return featured; }
    public int getDisplayOrder() { return displayOrder; }
    public Instant getCreatedAt() { return createdAt; }
    public List<String> getTechStack() { return techStack; }
}