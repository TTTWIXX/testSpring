package com.example.testtest.practice01.dto.page;

public class PageMaker {

    private int begin,end,finalPage; // 화면 렌더링시 페이지의 시작값과 끝값
    private int prev,next; //이전, 다음 버튼
    private static final int PAGE_COUNT=5; // 한번에 보여줄 페이지 수(몇 페이지씩 보여줄 것인가.)
    private Page page; // 현재 요청 페이지 정보
    private int totalCount; //총 게시물 수


}
