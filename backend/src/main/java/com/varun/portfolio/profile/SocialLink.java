package com.varun.portfolio.profile;

import jakarta.persistence.*;

@Entity
@Table(name = "social_link")
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform;
    private String url;
    private int displayOrder;

    protected SocialLink() {
    }

    public Long getId() { return id; }
    public String getPlatform() { return platform; }
    public String getUrl() { return url; }
    public int getDisplayOrder() { return displayOrder; }
}