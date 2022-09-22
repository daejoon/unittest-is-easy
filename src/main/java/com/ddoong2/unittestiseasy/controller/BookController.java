package com.ddoong2.unittestiseasy.controller;

import com.ddoong2.unittestiseasy.domain.Book;
import com.ddoong2.unittestiseasy.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@RequestBody BookRequest request) {
        bookRepository.save(request.toEntity());
    }

    @GetMapping
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }
}
