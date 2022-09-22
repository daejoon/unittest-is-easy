package com.ddoong2.unittestiseasy.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 12)
    private String isbn;

    @NotBlank
    @Size(min = 1, max = 255)
    private String title;

    @Size(max = 255)
    private String description;

    @NotBlank
    @Size(min = 2, max = 30)
    private String authorName;

    @Size(max = 255)
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
