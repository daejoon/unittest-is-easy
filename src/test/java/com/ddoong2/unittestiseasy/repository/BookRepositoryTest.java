package com.ddoong2.unittestiseasy.repository;

import com.ddoong2.unittestiseasy.domain.Book;
import com.ddoong2.unittestiseasy.util.FixtureMonkeyUtil;
import com.navercorp.fixturemonkey.FixtureMonkey;
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
                .authorName("이일민")
                .build();
        // When - 검증하려는 로직 실행
        final Book saveBook = bookRepository.save(book);
        // Then - 출력 확인
        assertThat(saveBook.getId()).isNotNull();
        assertThat(saveBook.getTitle()).isEqualTo("토비의 스프링 3.1 Vol. 1 스프링의 이해와 원리");
        assertThat(saveBook.getIsbn()).isEqualTo("8960773417");
        assertThat(saveBook.getAuthorName()).isEqualTo("이일민");
    }

    @Test
    @DisplayName("Fixture Monkey를 이용해서 저장한다")
    void Fixture_Monkey를_이용해서_저장한다() {

        // Given - 사전 조건 설정
        final FixtureMonkey fixture = FixtureMonkeyUtil.fixture();
        final Book book = fixture.giveMeBuilder(Book.class)
                .set("id", null)
                .sample();
        // When - 검증하려는 로직 실행
        final Book saveBook = bookRepository.save(book);
        // Then - 출력 확인
        assertThat(saveBook.getId()).isNotNull();
        assertThat(saveBook.getTitle()).isEqualTo(book.getTitle());
        assertThat(saveBook.getIsbn()).isEqualTo(book.getIsbn());
        assertThat(saveBook.getAuthorName()).isEqualTo(book.getAuthorName());
    }
}