package com.acmeflix.acmeflixApplication.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TVSHOW")
public class TVShow extends Program
{
    @OneToMany
    private List<Season> seasons;
}
