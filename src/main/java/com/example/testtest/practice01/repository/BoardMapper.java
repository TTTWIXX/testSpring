package com.example.testtest.practice01.repository;

import com.example.testtest.practice01.dto.BoardDetailResponseDTO;
import com.example.testtest.practice01.entity.Board;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface BoardMapper {
    //게시물 저장
    boolean save(Board board);
    //게시물 삭제

    boolean delete(int bno);

    //게시물 수정
    boolean modify();

    //게시물 전부 불러오기
    List<Board> findAll();

    Board findOne(int bno);
}
