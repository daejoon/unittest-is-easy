package com.ddoong2.unittestiseasy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class UnittestIsEasyApplicationTests {

    @Test
    @DisplayName("환경을 로드 한다")
    void 환경을_로드_한다() {

        // Given - 사전 조건 설정
        // When - 검증하려는 로직 실행
        // Then - 출력 확인
    }

}
