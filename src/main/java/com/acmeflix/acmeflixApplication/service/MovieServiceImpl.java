package com.acmeflix.acmeflixApplication.service;


import com.acmeflix.acmeflixApplication.domain.Movie;
import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService{
    private final MovieRepository movieRepository;

    @Override
    public JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }
}