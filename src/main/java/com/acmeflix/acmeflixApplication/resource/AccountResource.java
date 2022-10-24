package com.acmeflix.acmeflixApplication.resource;

import com.acmeflix.acmeflixApplication.domain.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString(callSuper = true)
public class AccountResource extends BaseResource {
    private String email;
    private String firstname;
    private String lastname;
    private Set<User> users = new HashSet<>();
}
