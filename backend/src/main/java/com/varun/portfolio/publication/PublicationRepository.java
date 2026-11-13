package com.varun.portfolio.publication;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

    // Derived query to sort by display_order
    List<Publication> findAllByOrderByDisplayOrderAsc();
}