package com.acmeflix.acmeflixApplication.domain;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNT_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel{
    @NotNull
    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @NotNull
    @Column(length = 20, nullable = false)
    private String firstname;
    @NotNull
    @Column(length = 20, nullable = false)
    private String lastname;
    @ToString.Exclude
    @OneToMany (cascade = CascadeType.MERGE, fetch = FetchType. EAGER)
    private Set<User> users;
}
