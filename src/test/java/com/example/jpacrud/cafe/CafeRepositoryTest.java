package com.example.jpacrud.cafe;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Transactional
public class CafeRepositoryTest {
    @Autowired
    private CafeRepository cafeRepository;

    @Test
    @DisplayName("카페 생성")
    void createCafe() {
        // given
        Cafe cafe = Cafe.builder()
                .name("스타벅스 송내")
                .mapX(0.0)
                .mapY(0.0)
                .site("https://www.starbucks.co.kr/index.do")
                .note("운영시간 오전 7:00~오후 10:00")
                .build();

        // when
        final Cafe savedCafe = cafeRepository.save(cafe);

        // then
        Assertions.assertThat(savedCafe.getName()).isEqualTo(cafe.getName());
    }

    @Test
    @DisplayName("카페 조회")
    void readCafe() {
        // given
        Cafe cafe = Cafe.builder()
                .name("스타벅스 송내")
                .mapX(0.0)
                .mapY(0.0)
                .site("https://www.starbucks.co.kr/index.do")
                .note("운영시간 오전 7:00~오후 10:00")
                .build();
        final Cafe savedCafe = cafeRepository.save(cafe);

        // when
        final Optional<Cafe> findCafe = cafeRepository.findById(savedCafe.getId());

        // then
        Assertions.assertThat(findCafe).isPresent();
        Assertions.assertThat(findCafe.get()).isEqualTo(savedCafe);
    }

    @Test
    @DisplayName("카페 수정")
    void updateCafe() {
        // given
        Cafe cafe = Cafe.builder()
                .name("스타벅스 송내")
                .mapX(0.0)
                .mapY(0.0)
                .site("https://www.starbucks.co.kr/index.do")
                .note("운영시간 오전 7:00~오후 10:00")
                .build();
        final Cafe savedCafe = cafeRepository.save(cafe);

        // when
        String newName = "스타벅스 부평역";
        savedCafe.updateCafeName(newName);

        // then
        Cafe updatedCafe = cafeRepository.findById(savedCafe.getId()).get();
        Assertions.assertThat(updatedCafe).isNotNull();
        Assertions.assertThat(updatedCafe.getName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("카페 삭제")
    void deleteCafe() {
        // given
        Cafe cafe = Cafe.builder()
                .name("스타벅스 송내")
                .mapX(0.0)
                .mapY(0.0)
                .site("https://www.starbucks.co.kr/index.do")
                .note("운영시간 오전 7:00~오후 10:00")
                .build();
        final Cafe savedCafe = cafeRepository.save(cafe);

        // when
        cafeRepository.delete(savedCafe);

        // then
        Optional<Cafe> updatedCafe = cafeRepository.findById(savedCafe.getId());
        Assertions.assertThat(updatedCafe.isPresent()).isFalse();
    }
}
