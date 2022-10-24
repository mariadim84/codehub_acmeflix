package com.acmeflix.acmeflixApplication.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class MovieResource extends BaseResource {
    private Integer duration;
    private Integer allowedAge;
    private Integer year;
}
