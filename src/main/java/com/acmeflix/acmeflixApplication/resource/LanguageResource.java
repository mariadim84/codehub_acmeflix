package com.acmeflix.acmeflixApplication.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class LanguageResource extends BaseResource {
    private String originalLanguage;
}
