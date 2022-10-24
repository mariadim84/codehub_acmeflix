package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.domain.User;

public interface UserService extends BaseService<User, Long> {
    public User findByUsername(String username);

}

