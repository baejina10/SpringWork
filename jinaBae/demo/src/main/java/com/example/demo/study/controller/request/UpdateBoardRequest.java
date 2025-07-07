package com.example.demo.study.controller.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBoardRequest {
    Long boardId;
    String title;
    String content;
}
