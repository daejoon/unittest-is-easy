package com.ddoong2.unittestiseasy.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String title;

    private String description;

    private String authorName;

    private String authorBio;

    @Builder
    protected Book(final Long id,
                   final String isbn,
                   final String title,
                   final String description,
                   final String authorName,
                   final String authorBio) {

        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.authorBio = authorBio;
    }
}
