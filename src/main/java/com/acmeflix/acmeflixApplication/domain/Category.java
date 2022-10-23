package com.acmeflix.acmeflixApplication.domain;

public enum Category {
    HORROR("Horror"), COMEDY("Comedy"), ACTION("Action"),  SCIFI("Sci-fi"),  DRAMA("Drama");

    private final String categoryDesc;

    Category(String Category) {
        this.categoryDesc = Category;
    }

}
