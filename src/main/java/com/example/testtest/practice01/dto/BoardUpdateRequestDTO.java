package com.example.testtest.practice01.dto;

import com.example.testtest.practice01.entity.Board;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class BoardUpdateRequestDTO {
    private int boardNo;
    private String title;
    private String content;
}
