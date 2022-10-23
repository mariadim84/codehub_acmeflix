package com.acmeflix.acmeflixApplication.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "USERS_SEQ", initialValue = 1, allocationSize = 1)
public class User extends BaseModel{
    private String username;
    private Integer age;
    @OneToMany(fetch = FetchType. EAGER)
    private Set<Program> recommendedPrograms;
}
