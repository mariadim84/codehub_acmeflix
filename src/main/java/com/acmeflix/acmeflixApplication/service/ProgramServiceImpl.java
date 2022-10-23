package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.domain.Category;
import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ProgramServiceImpl extends BaseServiceImpl<Program> implements ProgramService{
    private final ProgramRepository programRepository;

    @Override
    public JpaRepository<Program, Long> getRepository() {
        return programRepository;
    }
    @Override
    public Program findByTitle(final String title) {
        return programRepository.findByTitleIsContainingIgnoreCase(title).orElseThrow();
    }

    @Override
    public List<Program> findByCategory(final String category) {
        List<Program> programsFound = programRepository.findByCategoryIgnoreCase(category).orElseThrow();
        return programsFound;
    }
}
