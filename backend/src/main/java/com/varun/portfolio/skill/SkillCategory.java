package com.varun.portfolio.skill;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill_category")
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int displayOrder;

    // One category has many skills. "category" is the field in Skill that owns the link.
    @OneToMany(mappedBy = "category")
    @OrderBy("displayOrder ASC")
    private List<Skill> skills = new ArrayList<>();

    protected SkillCategory() {
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getDisplayOrder() { return displayOrder; }
    public List<Skill> getSkills() { return skills; }
}
