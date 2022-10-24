package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.domain.User;
import com.acmeflix.acmeflixApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    private final UserRepository userRepository;

    @Override
    public JpaRepository<User, Long> getRepository() {
        return userRepository;
    }
    @Override
    public User findByUsername(final String username) {
        return userRepository.findByUsernameIgnoreCase(username).orElseThrow();
    }

}
