package com.acmeflix.acmeflixApplication.controller;

import com.acmeflix.acmeflixApplication.base.BaseMapper;
import com.acmeflix.acmeflixApplication.domain.Account;
import com.acmeflix.acmeflixApplication.mapper.AccountMapper;
import com.acmeflix.acmeflixApplication.resource.AccountResource;
import com.acmeflix.acmeflixApplication.service.AccountService;
import com.acmeflix.acmeflixApplication.service.BaseService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController extends AbstractController<Account, AccountResource> {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @Override
    public BaseService<Account, Long> getBaseService() {
        return accountService;
    }

    @Override
    public BaseMapper<Account, AccountResource> getMapper() {
        return accountMapper;
    }

    @GetMapping(params = "email")
    public ResponseEntity<ApiResponse<AccountResource>> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(ApiResponse.<AccountResource>builder().data(getMapper().toResource(
               accountService.findByEmail(email))).build());
    }


}
