package com.varun.portfolio.experience;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String company;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private int displayOrder;

    // One Experience has Many Highlights.
    // "experience" refers to the field in ExperienceHighlight that owns the FK.
    @OneToMany(mappedBy = "experience")
    @OrderBy("displayOrder ASC")
    private List<ExperienceHighlight> highlights = new ArrayList<>();

    protected Experience() {
    }

    public Long getId() { return id; }
    public String getRole() { return role; }
    public String getCompany() { return company; }
    public String getLocation() { return location; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public int getDisplayOrder() { return displayOrder; }
    public List<ExperienceHighlight> getHighlights() { return highlights; }
}