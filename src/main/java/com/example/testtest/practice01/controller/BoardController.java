package com.example.testtest.practice01.controller;

import com.example.testtest.practice01.dto.BoardListRequestDTO;
import com.example.testtest.practice01.dto.BoardWriteRequestDTO;
import com.example.testtest.practice01.entity.Board;
import com.example.testtest.practice01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        List<BoardListRequestDTO> list = boardService.findAll();
        System.out.println(list);
        model.addAttribute("bList", list);
        return "/list";
    }

    // 글 추가 페이지 보여주는 기능
    @RequestMapping("/write")
    public String writePage() {

        return "/write";
    }

    // 새로운 게시물 정보를 받아 메인에 새로운 게시물을 보여주는 기능
    @RequestMapping
    public String save(Model model, BoardWriteRequestDTO dto) {
        boardService.save(dto);
        List<BoardListRequestDTO> all = boardService.findAll();
        model.addAttribute("blist",all);
        return "redirect:/list";

    }

    //저장하는 기능


}
