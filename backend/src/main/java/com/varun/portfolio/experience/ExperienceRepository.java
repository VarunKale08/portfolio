package com.varun.portfolio.experience;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    // Derived method: SELECT * FROM experience ORDER BY display_order ASC
    List<Experience> findAllByOrderByDisplayOrderAsc();
}