package com.acmeflix.acmeflixApplication.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "MOVIES")
public class Movie extends BaseModel//Program
{
    @Column
    private Integer duration;
    @Column
    private Integer allowedAge;
    @Column
    private Integer year;
}
