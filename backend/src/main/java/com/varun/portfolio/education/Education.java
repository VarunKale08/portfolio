package com.varun.portfolio.education;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;
    private String institution;
    private String location;
    private String grade;
    private String honors;

    private LocalDate endDate;
    private int displayOrder;

    // JPA needs a no-argument constructor.
    protected Education() {
    }

    public Long getId() { return id; }
    public String getDegree() { return degree; }
    public String getInstitution() { return institution; }
    public String getLocation() { return location; }
    public String getGrade() { return grade; }
    public String getHonors() { return honors; }
    public LocalDate getEndDate() { return endDate; }
    public int getDisplayOrder() { return displayOrder; }
}
