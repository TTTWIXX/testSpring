package com.example.testtest.practice01.dto.page;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private int pageNo; // 클라이언트가 보낸 페이지 번호 ex) 나는 3페이지 보고싶어
    private int amount; // 클라이언트가 보낸 게시물 수
}
