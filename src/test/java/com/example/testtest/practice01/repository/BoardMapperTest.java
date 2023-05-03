package com.example.testtest.practice01.repository;

import com.example.testtest.practice01.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    @DisplayName("제목과 내용을 입력하면 저장하는 기능")
    void save() {
        for (int i = 0; i < 10; i++) {
            Board build = Board.builder().title(i + "번 게시물 제목").content(i + "번 게시물 내용").build();
            boardMapper.save(build);

        }

    }


}