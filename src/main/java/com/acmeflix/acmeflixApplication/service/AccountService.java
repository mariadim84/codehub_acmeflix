package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.domain.Account;
import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.domain.User;

import java.util.List;

public interface AccountService extends BaseService<Account, Long> {
    public Account findByEmail(String email);
    public void addUser(Account account, User user) ;

}

