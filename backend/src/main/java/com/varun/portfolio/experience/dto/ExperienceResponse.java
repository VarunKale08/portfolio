package com.varun.portfolio.experience.dto;

import com.varun.portfolio.experience.Experience;
import com.varun.portfolio.experience.ExperienceHighlight;
import java.time.LocalDate;
import java.util.List;

public record ExperienceResponse(
        String role,
        String company,
        String location,
        LocalDate startDate,
        LocalDate endDate,
        List<HighlightResponse> highlights
) {
    public static ExperienceResponse from(Experience experience) {
        return new ExperienceResponse(
                experience.getRole(),
                experience.getCompany(),
                experience.getLocation(),
                experience.getStartDate(),
                experience.getEndDate(),
                experience.getHighlights().stream().map(HighlightResponse::from).toList()
        );
    }

    public record HighlightResponse(String title, String detail) {
        public static HighlightResponse from(ExperienceHighlight highlight) {
            return new HighlightResponse(highlight.getTitle(), highlight.getDetail());
        }
    }
}