package com.varun.portfolio.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    // As specified: returns the first row, or empty if the table has none.
    Optional<Profile> findFirstByOrderByIdAsc();
}