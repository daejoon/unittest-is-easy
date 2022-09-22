package com.ddoong2.unittestiseasy.repository;


import com.ddoong2.unittestiseasy.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
