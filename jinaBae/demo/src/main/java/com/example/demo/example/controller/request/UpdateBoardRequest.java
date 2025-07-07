package com.example.demo.example.controller.request;

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
