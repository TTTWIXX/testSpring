package com.example.testtest.practice01.controller;

import com.example.testtest.practice01.dto.BoardDetailResponseDTO;
import com.example.testtest.practice01.dto.BoardListResponseDTO;
import com.example.testtest.practice01.dto.BoardUpdateRequestDTO;
import com.example.testtest.practice01.dto.BoardWriteRequestDTO;
import com.example.testtest.practice01.dto.page.Page;
import com.example.testtest.practice01.dto.page.PageMaker;
import com.example.testtest.practice01.entity.Board;
import com.example.testtest.practice01.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
@Slf4j
public class BoardController {
    private final BoardService boardService;

    // 전체 목록 조회
    @GetMapping("/list")
    public String showList(Model model, Page page) {

        List<BoardListResponseDTO> list = boardService.findAll();
        PageMaker P=new PageMaker(page,);
        model.addAttribute("bList", list);
        model.addAttribute("p",pageMaker);
        return "/list";
    }

    // 글 추가 페이지 보여주는 기능
    @GetMapping("/write")
    public String writePage() {
        return "/write";
    }

    // 새로운 게시물 정보를 받아 메인에 새로운 게시물을 보여주는 기능
    @PostMapping("/write")
    public String save(BoardWriteRequestDTO dto) {
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

    // 글 수정 페이지 보여주기
    @PostMapping("/update")
    public String update(Model model, BoardUpdateRequestDTO dto) {
        Board board = new Board(dto);
        System.out.println("board = " + board);
        System.out.println("dto = " + dto);
        model.addAttribute("c", board);
        return "update";
    }

    // 수정완료
    @PostMapping("/modify")
    public String finishUpdate(BoardUpdateRequestDTO dto) {

        boardService.modify(dto);

        return "redirect:/test/list";
    }



}
