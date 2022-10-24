package com.acmeflix.acmeflixApplication.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EPISODES")
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODE_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel{
    @NotNull
    @Column(length = 100, nullable = false)
    private String title;
    @NotNull
    private Integer duration;

}
