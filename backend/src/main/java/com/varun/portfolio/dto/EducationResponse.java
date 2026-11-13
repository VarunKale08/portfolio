package com.varun.portfolio.dto;

import com.varun.portfolio.education.Education;
import java.time.LocalDate;

public record EducationResponse(
        String degree,
        String institution,
        String location,
        String grade,
        String honors,
        LocalDate endDate
) {
    // Static factory method to map Entity -> DTO
    public static EducationResponse from(Education education) {
        return new EducationResponse(
                education.getDegree(),
                education.getInstitution(),
                education.getLocation(),
                education.getGrade(),
                education.getHonors(),
                education.getEndDate()
        );
    }
}
