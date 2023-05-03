package com.example.testtest.practice01.controller;

import com.example.testtest.practice01.dto.BoardDetailResponseDTO;
import com.example.testtest.practice01.dto.BoardListResponseDTO;
import com.example.testtest.practice01.dto.boardWriteRequestDTO;
import com.example.testtest.practice01.entity.Board;
import com.example.testtest.practice01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class BoardController {
    private final BoardService boardService;

    // 전체 목록 조회
    @GetMapping("/list")
    public String showList(Model model) {

        List<BoardListResponseDTO> list = boardService.findAll();
        model.addAttribute("bList", list);
        return "/list";
    }

    // 글 추가 페이지 보여주는 기능
    @GetMapping("/write")
    public String writePage() {
        return "/write";
    }

    // 새로운 게시물 정보를 받아 메인에 새로운 게시물을 보여주는 기능
    @PostMapping("/write")
    public String save(boardWriteRequestDTO dto) {
        boardService.save(dto);
//        System.out.println("save = " + save);
        return "redirect:/test/list";

    }

    // 삭제 기능
    @GetMapping("/delete")
    public String delete(int bno) {
        boardService.delete(bno);
        return "redirect:/test/list";
    }

    // 글 상세 요청
    @GetMapping("/detail")
    public String detail(int bno, Model model) {
        BoardDetailResponseDTO one = boardService.findOne(bno);
        model.addAttribute("b", one);
        return "/detail";
    }


}
