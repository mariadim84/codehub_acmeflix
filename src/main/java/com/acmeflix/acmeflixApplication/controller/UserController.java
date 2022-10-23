package com.acmeflix.acmeflixApplication.controller;

import com.acmeflix.acmeflixApplication.base.BaseMapper;
import com.acmeflix.acmeflixApplication.domain.User;
import com.acmeflix.acmeflixApplication.mapper.UserMapper;
import com.acmeflix.acmeflixApplication.resource.UserResource;
import com.acmeflix.acmeflixApplication.service.UserService;
import com.acmeflix.acmeflixApplication.service.BaseService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController extends AbstractController<User, UserResource> {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public BaseService<User, Long> getBaseService() {
        return userService;
    }

    @Override
    public BaseMapper<User, UserResource> getMapper() {
        return userMapper;
    }

    @GetMapping(params = "username")
    public ResponseEntity<ApiResponse<UserResource>> findByUsername(@RequestParam String username) {
        return ResponseEntity.ok(ApiResponse.<UserResource>builder().data(getMapper().toResource(
                userService.findByUsername(username))).build());
    }


}
