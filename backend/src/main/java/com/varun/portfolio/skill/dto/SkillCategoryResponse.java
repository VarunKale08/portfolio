package com.varun.portfolio.skill.dto;

import java.util.List;

import com.varun.portfolio.skill.Skill;
import com.varun.portfolio.skill.SkillCategory;

public record SkillCategoryResponse(String category, List<String> skills) {

    public static SkillCategoryResponse from(SkillCategory category) {
        return new SkillCategoryResponse(
                category.getName(),
                category.getSkills().stream().map(Skill::getName).toList());
    }
}