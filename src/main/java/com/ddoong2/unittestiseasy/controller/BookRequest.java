package com.ddoong2.unittestiseasy.controller;

import com.ddoong2.unittestiseasy.domain.Book;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BookRequest {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private String authorBio;
    public Book toEntity() {
        return Book.builder()
                .isbn(this.isbn)
                .title(this.title)
                .description(this.description)
                .authorName(this.authorName)
                .authorBio(this.authorBio)
                .build();
    }
}
