package com.acmeflix.acmeflixApplication.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "PROGRAMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PROGRAM_SEQ", initialValue = 1, allocationSize = 1)
public class Program extends BaseModel{
    @NotNull
    @Column(length = 100, nullable = false)
    private String title;
    @NotNull
    @Column
    private String category;
    @NotNull
    @Column(precision = 3, scale = 2, nullable = false)
    private float rating;
    @ManyToMany(fetch = FetchType. EAGER)
    @Column
    private Set<Program> recommendations;
    @ManyToMany(fetch = FetchType. EAGER)
    @Column
    private Set<Subtitle> subtitles;
    @ManyToMany(fetch = FetchType. EAGER)
    @Column
    private Set<Language> languages;

}
