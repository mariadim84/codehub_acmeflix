package com.acmeflix.acmeflixApplication.service;


import com.acmeflix.acmeflixApplication.domain.Account;
import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.domain.User;

import java.util.List;

public interface UserService extends BaseService<User, Long> {
    public User findByUsername(String username);

}

