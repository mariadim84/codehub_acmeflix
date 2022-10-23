package com.acmeflix.acmeflixApplication.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TVSHOW")
public class TVShow extends BaseModel//Program
{
    private Integer duration;
    private Integer allowedAge;
    private Integer year;
    @OneToMany
    private List<Season> seasons;
}
