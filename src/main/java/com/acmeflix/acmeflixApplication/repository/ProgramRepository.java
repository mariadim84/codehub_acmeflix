package com.acmeflix.acmeflixApplication.repository;

import com.acmeflix.acmeflixApplication.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    Optional<Program> findByTitleIsContainingIgnoreCase(final String title);
    Optional<List<Program>> findByCategoryIgnoreCase(final String category);

}
