package com.varun.portfolio.experience;

import jakarta.persistence.*;

@Entity
@Table(name = "experience_highlight")
public class ExperienceHighlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many Highlights belong to One Experience.
    // This side OWNS the foreign key column (experience_id).
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experience_id")
    private Experience experience;

    private String title;
    private String detail;
    private int displayOrder;

    protected ExperienceHighlight() {
    }

    public Long getId() { return id; }
    public Experience getExperience() { return experience; }
    public String getTitle() { return title; }
    public String getDetail() { return detail; }
    public int getDisplayOrder() { return displayOrder; }
}