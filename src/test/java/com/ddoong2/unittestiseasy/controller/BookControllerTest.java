package com.ddoong2.unittestiseasy.controller;

import com.ddoong2.unittestiseasy.domain.Book;
import com.ddoong2.unittestiseasy.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @MockBean BookRepository bookRepository;
    @Test @DisplayName("책을 저장 합니다")
    void 책을_저장_합니다() throws Exception {
        // Given - 사전 조건 설정
        final BookRequest bookRequest = BookRequest.builder()
                .title("토비의 스프링 3.1 Vol. 1 스프링의 이해와 원리")
                .description("")
                .isbn("8960773417")
                .build();
        final Book book = Book.builder()
                .id(1L)
                .title("토비의 스프링 3.1 Vol. 1 스프링의 이해와 원리")
                .description("")
                .isbn("8960773417")
                .build();
        given(bookRepository.save(isA(Book.class))).willReturn(book);
        // When - 검증하려는 로직 실행
        final ResultActions result =
                this.mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookRequest))
                );
        // Then - 출력 확인
        result.andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("모든 책을 가져온다")
    void 모든_책을_가져온다() throws Exception {
        // Given - 사전 조건 설정
        final Book book = Book.builder()
                .id(1L)
                .title("토비의 스프링 3.1 Vol. 1 스프링의 이해와 원리")
                .description("")
                .isbn("8960773417")
                .build();
        given(bookRepository.findAll()).willReturn(List.of(book));
        // When - 검증하려는 로직 실행
        final ResultActions result = this.mockMvc.perform(get("/books"));
        // Then - 출력 확인
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").value("토비의 스프링 3.1 Vol. 1 스프링의 이해와 원리"));
    }
}