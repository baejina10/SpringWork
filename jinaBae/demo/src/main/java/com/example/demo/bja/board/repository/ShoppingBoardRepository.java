package com.example.demo.bja.board.repository;

import com.example.demo.bja.board.entity.ShoppingBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBoardRepository extends JpaRepository<ShoppingBoard,Long> {
}
