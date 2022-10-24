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
@Table(name = "SUBTITLES")
@SequenceGenerator(name = "idGenerator", sequenceName = "SUBTITLE_SEQ", initialValue = 1, allocationSize = 1)
public class Subtitle extends BaseModel{
    private String subtitleLanguage;
}
