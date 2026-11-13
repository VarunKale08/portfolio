package com.varun.portfolio.profile;

import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    private String title;
    private String tagline;
    private String about;
    private String location;

    protected Profile() {
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getTitle() { return title; }
    public String getTagline() { return tagline; }
    public String getAbout() { return about; }
    public String getLocation() { return location; }
}