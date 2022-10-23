package com.acmeflix.acmeflixApplication.resource;

import com.acmeflix.acmeflixApplication.domain.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@ToString(callSuper = true)
public class MovieResource extends BaseResource {
    private Integer duration;
    private Integer allowedAge;
    private Integer year;
}
