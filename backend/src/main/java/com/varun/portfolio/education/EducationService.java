package com.varun.portfolio.education;


import com.varun.portfolio.education.dto.EducationResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // As requested in the hint
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<EducationResponse> getAll() {
        return educationRepository.findAllByOrderByDisplayOrderAsc()
                .stream()
                .map(EducationResponse::from)
                .toList();
    }
}