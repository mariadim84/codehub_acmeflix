package com.acmeflix.acmeflixApplication.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie extends BaseModel
{
    private Integer duration;
    private Integer allowedAge;
    private Integer year;
}
