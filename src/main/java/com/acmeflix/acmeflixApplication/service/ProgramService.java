package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.domain.Category;
import com.acmeflix.acmeflixApplication.domain.Program;

import java.util.List;


public interface ProgramService extends BaseService<Program, Long> {
    public Program findByTitle(String title);
    public List<Program> findByCategory(String category);

}

