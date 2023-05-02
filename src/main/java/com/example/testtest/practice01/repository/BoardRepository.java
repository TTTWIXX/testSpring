package com.example.testtest.practice01.repository;

import com.example.testtest.practice01.dto.BoardListRequestDTO;
import com.example.testtest.practice01.entity.Board;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

@Repository
public class BoardRepository implements BoardMapper {

    private static final Map<Integer, Board> mapList;
    static int sequence;

    static {
        mapList = new HashMap<>();
        Board b1 = new Board(++sequence, "이건 제목1", "이건 내용1", 0, LocalDateTime.now());
        Board b2 = new Board(++sequence, "이건 제목2", "이건 내용2", 0, LocalDateTime.now());
        Board b3 = new Board(++sequence, "이건 제목3", "이건 내용3", 0, LocalDateTime.now());
        mapList.put(b1.getBoardNo(), b1);
        mapList.put(b2.getBoardNo(), b2);
        mapList.put(b3.getBoardNo(), b3);


    }


    @Override
    public Board save(Board board) {

        return mapList.put(board.getBoardNo(),board);
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean modify() {
        return false;
    }

    @Override
    public List<Board> findAll() {
        return mapList.values().stream()
                .sorted(comparing(Board::getBoardNo))
                .collect(toList());
    }
}
