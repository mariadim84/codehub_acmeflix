package com.acmeflix.acmeflixApplication.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1)
public class User extends BaseModel{
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType. EAGER)
    @JsonIgnore
    private Account account;
    private String username;
    private Integer age;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType. EAGER)
    private Set<Program> recommendedPrograms;
}
