package com.acmeflix.acmeflixApplication.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SEASONS")
@SequenceGenerator(name = "idGenerator", sequenceName = "SEASON_SEQ", initialValue = 1, allocationSize = 1)
public class Season extends BaseModel{
    @NotNull
    private Integer seasonNumber;
    @OneToMany
    @NotNull
    private List<Episode> episodes;

}
