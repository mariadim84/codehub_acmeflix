package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl extends BaseServiceImpl<Program> implements ProgramService{
    private final ProgramRepository programRepository;

    @Override
    public JpaRepository<Program, Long> getRepository() {
        return programRepository;
    }

}
