package com.example.testtest.practice01.entity;

import com.example.testtest.practice01.dto.boardWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    private int boardNo; //게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private LocalDateTime regDatetime; //작성일자


    public Board(boardWriteRequestDTO dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.regDatetime=LocalDateTime.now();
    }






}
