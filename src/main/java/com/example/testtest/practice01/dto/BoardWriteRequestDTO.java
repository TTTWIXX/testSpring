package com.example.testtest.practice01.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// 클라이언트가 보내는 것을 받는다.
@Getter
@ToString
@Setter
public class BoardWriteRequestDTO {

    private String title;
    private String content;
}
