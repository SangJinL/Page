package com.example.test.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno; // 글번호
    private String title; // 글 제목
    private String content; // 글 내용
    private String writerEmail; // 작성자 E-mail
    private String writerName; // 작성자
    private LocalDateTime regDate; // 글 작성 날짜
    private LocalDateTime modDate; // 글 수정 날짜
    private int replyCount; // 해당 게시글의 댓글 개수
}
