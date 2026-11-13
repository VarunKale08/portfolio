package com.varun.portfolio.dto;

//package com.varun.portfolio.project.dto;

import java.util.List;

import com.varun.portfolio.project.Project;

public record ProjectResponse(
        String slug,
        String title,
        String summary,
        String description,
        String imageUrl,
        String githubUrl,
        String liveUrl,
        boolean featured,
        List<String> techStack) {

    public static ProjectResponse from(Project project) {
        return new ProjectResponse(
                project.getSlug(),
                project.getTitle(),
                project.getSummary(),
                project.getDescription(),
                project.getImageUrl(),
                project.getGithubUrl(),
                project.getLiveUrl(),
                project.isFeatured(),
                List.copyOf(project.getTechStack()));
    }
}