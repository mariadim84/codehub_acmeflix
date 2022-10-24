package com.acmeflix.acmeflixApplication.resource;
import com.acmeflix.acmeflixApplication.domain.Account;
import com.acmeflix.acmeflixApplication.domain.Program;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString(callSuper = true)
public class UserResource extends BaseResource {
    private Account account;
    private String username;
    private Integer age;
    private Set<Program> recommendedPrograms = new HashSet<>();;
}
