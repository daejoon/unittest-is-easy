package com.ddoong2.unittestiseasy.repository;

import com.ddoong2.unittestiseasy.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("책을 저장한다")
    void 책을_저장한다() {
        // Given - 사전 조건 설정
        final Book book = Book.builder()
                .title("토비의 스프링 3.1 Vol. 1 스프링의 이해와 원리")
                .description("")
                .isbn("8960773417")
                .build();
        // When - 검증하려는 로직 실행
        final Book saveBook = bookRepository.save(book);
        // Then - 출력 확인
        assertThat(saveBook.getId()).isNotNull();
        assertThat(saveBook.getTitle()).isEqualTo(book.getTitle());
        assertThat(saveBook.getIsbn()).isEqualTo(book.getIsbn());
    }
}