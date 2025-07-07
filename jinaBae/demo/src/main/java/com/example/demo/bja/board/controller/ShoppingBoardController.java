package com.example.demo.bja.board.controller;

import com.example.demo.bja.board.controller.request_form.ShoppingBoardRequestForm;
import com.example.demo.bja.board.entity.ShoppingBoard;
import com.example.demo.bja.board.service.ShoppingBoardService;
import com.example.demo.bja.board.service.request.ShoppingBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class ShoppingBoardController {
    private final ShoppingBoardService shoppingBoardService;

    // 생성
    @PostMapping("/shoppingBoard/create")
    public ShoppingBoard createBoard(@RequestBody ShoppingBoardRequestForm request){
        ShoppingBoardRequest requestCreate = request.toShoppingBoardCreate();
        return shoppingBoardService.create(requestCreate);
    }

    // 1개만 조회
    @GetMapping("/shoppingBoard/{id}")
    public ShoppingBoard getBoard(@PathVariable Long id){
        return shoppingBoardService.findById(id);
    }

    // 전체 조회
    @GetMapping("/shoppingBoard/list")
    public List<ShoppingBoard> ShoppingBoardAll(){
        return shoppingBoardService.findShoppingBoardAll();
    }

    // 수정
    @PostMapping("/shoppingBoard/update")
    public ShoppingBoard updateBoard(@RequestBody ShoppingBoardRequestForm request){
        ShoppingBoardRequest requestUpdate = request.toShoppingBoardUpdate();
        return shoppingBoardService.update(requestUpdate);
    }


    // 삭제
    @GetMapping("/shoppingBoard/delete")
    public void deleteBoard(@RequestParam Long id){
        shoppingBoardService.delete(id);
    }
}
