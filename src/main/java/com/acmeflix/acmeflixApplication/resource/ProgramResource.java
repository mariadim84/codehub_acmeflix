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
public class ProgramResource extends BaseResource {
    private String title;
    private Category category;
    private String rating;
    private Set<ProgramResource> recommendations = new HashSet<>();
    private Set<LanguageResource> languages = new HashSet<>();
    private Set<SubtitleResource> subtitles = new HashSet<>();

}
