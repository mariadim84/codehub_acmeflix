package com.acmeflix.acmeflixApplication.repository;

import com.acmeflix.acmeflixApplication.domain.Account;
import com.acmeflix.acmeflixApplication.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(final String email);
}
