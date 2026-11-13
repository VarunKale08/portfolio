package com.varun.portfolio.project;

import java.util.List;

import com.varun.portfolio.project.dto.ProjectResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varun.portfolio.common.NotFoundException;
//import com.varun.portfolio.project.dto.ProjectResponse;

@Service
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectResponse> getAll() {
        return projectRepository.findAllByOrderByFeaturedDescDisplayOrderAsc()
                .stream()
                .map(ProjectResponse::from)
                .toList();
    }

    public ProjectResponse getBySlug(String slug) {
        return projectRepository.findBySlug(slug)
                .map(ProjectResponse::from)
                .orElseThrow(() -> new NotFoundException("Project not found: " + slug));
    }
}
