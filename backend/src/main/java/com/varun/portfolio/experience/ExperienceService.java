package com.varun.portfolio.experience;

import com.varun.portfolio.experience.dto.ExperienceResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<ExperienceResponse> getAll() {
        return experienceRepository.findAllByOrderByDisplayOrderAsc()
                .stream()
                .map(ExperienceResponse::from)
                .toList();
    }
}