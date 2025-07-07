package com.example.demo.bja.board.controller.request_form;

import com.example.demo.bja.board.service.request.ShoppingBoardRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ShoppingBoardRequestForm {
    Long id;
    String title;
    String content;
    String writer;

    public ShoppingBoardRequest toShoppingBoardUpdate(){
        return new ShoppingBoardRequest(id,title, content, writer);
    }

    public ShoppingBoardRequest toShoppingBoardCreate(){
        return new ShoppingBoardRequest(title, content, writer);
    }
}
