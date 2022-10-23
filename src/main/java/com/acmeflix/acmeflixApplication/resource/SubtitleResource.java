package com.acmeflix.acmeflixApplication.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class SubtitleResource extends BaseResource {
    private String subtitleLanguage;
}
