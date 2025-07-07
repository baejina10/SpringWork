package com.example.demo.study.controller.request;

import com.example.demo.study.entity.Fruit;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FruitRequest {
    Long id;
    String name;
    @Setter
    int price;

    public Fruit toFruit(){
        return new Fruit(name, price);
    }
}
