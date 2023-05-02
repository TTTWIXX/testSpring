package com.example.testtest.practice01.repository;

import com.example.testtest.practice01.entity.Board;


import java.util.List;


public interface BoardMapper {
    //게시물 저장
    Board save(Board board);
    //게시물 삭제
    boolean delete();
    //게시물 수정
    boolean modify();

    //게시물 전부 불러오기
    List<Board> findAll();

}
