package com.example.demo.bja.board.service;

import com.example.demo.bja.board.entity.ShoppingBoard;
import com.example.demo.bja.board.service.request.ShoppingBoardRequest;

import java.util.List;

public interface ShoppingBoardService {
    ShoppingBoard create(ShoppingBoardRequest shoppingBoardRequest);
    ShoppingBoard findById(Long id);
    List<ShoppingBoard> findShoppingBoardAll();
    ShoppingBoard update(ShoppingBoardRequest shoppingBoardRequest);
    void delete(Long id);
}
