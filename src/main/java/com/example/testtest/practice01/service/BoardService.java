package com.example.testtest.practice01.service;

import com.example.testtest.practice01.dto.BoardDetailResponseDTO;
import com.example.testtest.practice01.dto.BoardListResponseDTO;
import com.example.testtest.practice01.dto.boardWriteRequestDTO;
import com.example.testtest.practice01.entity.Board;
import com.example.testtest.practice01.repository.BoardMapper;
import com.example.testtest.practice01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardRepository;

    public List<BoardListResponseDTO> findAll() {

        return boardRepository.findAll().stream().map(BoardListResponseDTO::new).collect(Collectors.toList());
    }

    public void save(boardWriteRequestDTO dto) {
        boardRepository.save(new Board(dto));
    }

    public boolean delete(int boardNo) {

        return boardRepository.delete(boardNo);
    }

    public BoardDetailResponseDTO findOne(int bno) {
        Board one = boardRepository.findOne(bno);
        return new BoardDetailResponseDTO(one);
    }
}
