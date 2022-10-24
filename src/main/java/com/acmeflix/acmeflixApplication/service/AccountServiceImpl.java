package com.acmeflix.acmeflixApplication.service;

import com.acmeflix.acmeflixApplication.domain.Account;
import com.acmeflix.acmeflixApplication.domain.User;
import com.acmeflix.acmeflixApplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{
    private final AccountRepository accountRepository;

    @Override
    public JpaRepository<Account, Long> getRepository() {
        return accountRepository;
    }
    @Override
    public Account findByEmail(final String email) {
        return accountRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public void addUser(Account account, User user) {

        for (User oi : account.getUsers()) {
            if (oi.getUsername().equals(user.getUsername())) {
                break;
            }
        }
        account.getUsers().add(newUser(account, user));

        logger.debug("User[{}] added to Account[{}]", account, user);
    }


    private User newUser(Account account , User user) {
        return User.builder().account(account).username(user.getUsername()).age(user.getAge()).build();
    }

}
