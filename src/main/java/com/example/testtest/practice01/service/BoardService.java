package com.example.testtest.practice01.service;

import com.example.testtest.practice01.dto.BoardListRequestDTO;
import com.example.testtest.practice01.dto.BoardWriteRequestDTO;
import com.example.testtest.practice01.entity.Board;
import com.example.testtest.practice01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class BoardService {
    private  final BoardRepository boardRepository;

    public List<BoardListRequestDTO> findAll() {

        return boardRepository.findAll().stream().map(BoardListRequestDTO::new).collect(Collectors.toList());
    }

    public Board save(BoardWriteRequestDTO dto) {
        Board board = new Board(dto);
        return boardRepository.save(board);
    }
}
