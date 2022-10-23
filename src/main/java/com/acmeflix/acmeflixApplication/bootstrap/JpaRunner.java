package com.acmeflix.acmeflixApplication.bootstrap;

import com.acmeflix.acmeflixApplication.base.BaseComponent;
import com.acmeflix.acmeflixApplication.domain.*;
import com.acmeflix.acmeflixApplication.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class JpaRunner extends BaseComponent implements CommandLineRunner {
    private final ProgramService programService;
    private final BaseService languageService;
    private final BaseService subtitleService;
    private final BaseService movieService;
    private final AccountService accountService;
    private final UserService userService;



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
                        .category(Category.DRAMA.toString())
                        .rating(4.5f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title("Rocky")
                        .category(Category.ACTION.toString())
                        .rating(4.0f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title("Pulp Fiction")
                        .category(Category.DRAMA.toString())
                        .rating(5.0f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title(" A Clockwork Orange ")
                        .category(Category.SCIFI.toString())
                        .rating(4.5f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build(),
                Program.builder().title("Inception")
                        .category(Category.ACTION.toString())
                        .rating(5f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build())
        ;
        programs.forEach(programService::create);

     /*   List<Movie> movies = movieService.createAll(
                Movie.builder()
                        .title("Pulp Fiction")
                        .category(Category.DRAMA)
                        .rating(5.0f)
                        .recommendations(new HashSet<>())
                        .subtitles(subtitles1)
                        .languages(languages1)
                        .build());
        movies.forEach(movieService::create);*/

        List<Account> accounts = accountService.createAll(
                Account.builder().email("mariadim84@gmail.com")
                        .firstname("Maria")
                        .lastname("Dimitropoulou")
                        .users(new HashSet<>())
                        .build(),
                Account.builder().email("florazineli@gmail.com")
                        .firstname("Flora")
                        .lastname("Zineli")
                        .users(new HashSet<>())
                        .build());
        accounts.forEach(accountService::create);

        List<User> users = userService.createAll(
                User.builder().username("mariadim")
                        .age(39)
                        .recommendedPrograms(new HashSet<>())
                        .build(),
                User.builder().username("nikos")
                        .age(20)
                        .recommendedPrograms(new HashSet<>())
                        .build());
        users.forEach(userService::create);

    }
}
