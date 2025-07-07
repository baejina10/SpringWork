package com.example.demo.study.controller.request;

import com.example.demo.study.entity.Board;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    String title;
    String content;

    public Board toBoard() {
        return new Board(title, content);
    }
}
