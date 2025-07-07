package com.example.demo.bja.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@RequiredArgsConstructor
public class ShoppingBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Setter
    String title;
    @Setter
    String content;
    String writer;

    public ShoppingBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ShoppingBoard(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
