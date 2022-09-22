package com.ddoong2.unittestiseasy.controller;

import com.ddoong2.unittestiseasy.domain.Book;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BookRequest {
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
