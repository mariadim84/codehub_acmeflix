package com.acmeflix.acmeflixApplication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUBTITLES")
@SequenceGenerator(name = "idGenerator", sequenceName = "SUBTITLES_SEQ", initialValue = 1, allocationSize = 1)
public class Subtitle extends BaseModel{
    private String subtitleLanguage;
}
