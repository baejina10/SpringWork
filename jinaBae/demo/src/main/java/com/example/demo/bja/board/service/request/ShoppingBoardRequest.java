package com.example.demo.bja.board.service.request;

import com.example.demo.bja.board.entity.ShoppingBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ShoppingBoardRequest {
    Long id;

    @Setter
    String title;
    @Setter
    String content;

    String writer;

    public ShoppingBoardRequest(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public ShoppingBoardRequest(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public ShoppingBoard toShoppingBoardCreate(){
        return new ShoppingBoard(title,content,writer);
    }
}
