package com.example.testtest.practice01.dto;

import com.example.testtest.practice01.entity.Board;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@ToString
@Getter
public class BoardListResponseDTO {
    private int boardNo; //게시글 번호
    private String shortTitle; // 제목
    private String shortContent; // 내용
    private int viewCount; // 조회수
    private String date; //작성일자
// 서버가 응답할때

    public BoardListResponseDTO(Board board) {
        this.boardNo = board.getBoardNo();
        this.shortTitle = shortTitle(board.getTitle());
        this.shortContent = shortContent(board.getContent());
        this.viewCount=board.getViewCount();
        this.date = getTime(board.getRegDatetime());
    }

    public static String getTime(LocalDateTime regDatetime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern ("yyMMdd HH:mm:ss");
        return pattern.format(regDatetime);
    }

    private String shortContent(String content) {
        return shortString(content, 20);
    }

    private String shortTitle(String title) {

        return shortString(title, 8);
    }

    private static String shortString(String title, int end) {
        return (title.length() > end) ? title.substring(0, end) + "..." : title;
    }
}
