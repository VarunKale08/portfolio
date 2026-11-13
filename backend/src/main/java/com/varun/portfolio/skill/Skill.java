package com.varun.portfolio.skill;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many skills belong to one category. This side holds the foreign key column.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private SkillCategory category;

    private String name;
    private int displayOrder;

    protected Skill() {
    }

    public Long getId() { return id; }
    public SkillCategory getCategory() { return category; }
    public String getName() { return name; }
    public int getDisplayOrder() { return displayOrder; }
}
