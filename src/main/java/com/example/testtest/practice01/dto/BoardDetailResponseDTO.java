package com.example.testtest.practice01.dto;

import com.example.testtest.practice01.entity.Board;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class BoardDetailResponseDTO {


    private int boardNo;
    private String title;
    private String content;
    private String date;

    public BoardDetailResponseDTO(Board board) {
        this.boardNo = board.getBoardNo();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.date = BoardListResponseDTO.getTime(board.getRegDatetime());

    }


}
