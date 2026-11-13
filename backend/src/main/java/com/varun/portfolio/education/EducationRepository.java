package com.varun.portfolio.education;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {

    // The hint from the prompt: gives you the correct ordering
    List<Education> findAllByOrderByDisplayOrderAsc();
}