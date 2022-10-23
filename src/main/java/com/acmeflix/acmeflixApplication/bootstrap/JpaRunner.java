package com.acmeflix.acmeflixApplication.bootstrap;

import com.acmeflix.acmeflixApplication.base.BaseComponent;
import com.acmeflix.acmeflixApplication.domain.*;
import com.acmeflix.acmeflixApplication.service.BaseService;
import com.acmeflix.acmeflixApplication.service.ProgramService;
import com.acmeflix.acmeflixApplication.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class JpaRunner extends BaseComponent implements CommandLineRunner {
    private final ProgramService programService;
    private final BaseService languageService;
    private final BaseService subtitleService;



    @Override
    public void run(final String... args) throws Exception {

        List<Language> languages = List.of(
                Language.builder().originalLanguage("English").build(),
                Language.builder().originalLanguage("French").build(),
                Language.builder().originalLanguage("Greek").build(),
                Language.builder().originalLanguage("Turkish").build(),
                Language.builder().originalLanguage("Spanish").build(),
                Language.builder().originalLanguage("Italian").build()
        );
        languages.forEach(languageService::create);
        List<Subtitle> subtitles = List.of(
                Subtitle.builder().subtitleLanguage("English").build(),
                Subtitle.builder().subtitleLanguage("French").build(),
                Subtitle.builder().subtitleLanguage("Greek").build(),
                Subtitle.builder().subtitleLanguage("Turkish").build(),
                Subtitle.builder().subtitleLanguage("Spanish").build(),
                Subtitle.builder().subtitleLanguage("Italian").build()
        );
        subtitles.forEach(subtitleService::create);
        final Set<Subtitle> subtitles1 = new HashSet<Subtitle>();
        subtitles1.add(subtitles.get(0));
        subtitles1.add(subtitles.get(1));
        final Set<Language> languages1 = new HashSet<Language>();
        languages1.add(languages.get(2));
        languages1.add(languages.get(3));
        languages1.add(languages.get(4));

        List<Program> programs = programService.createAll(
                Program.builder().title("Great Expectations")
                        .category(Category.DRAMA)
                        .rating(4.5f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title("Rocky")
                        .category(Category.ACTION)
                        .rating(4.0f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title("Pulp Fiction")
                        .category(Category.DRAMA)
                        .rating(5.0f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title(" A Clockwork Orange ")
                        .category(Category.SCIFI)
                        .rating(4.5f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title("Inception")
                        .category(Category.ACTION)
                        .rating(5f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build())
        ;
        programs.forEach(programService::create);

    }
    //@formatter:on
}
