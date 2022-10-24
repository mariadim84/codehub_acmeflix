package com.acmeflix.acmeflixApplication.domain;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LANGUAGES")
@SequenceGenerator(name = "idGenerator", sequenceName = "LANGUAGE_SEQ", initialValue = 1, allocationSize = 1)
public class Language extends BaseModel {
    private String originalLanguage;
}
