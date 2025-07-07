package com.example.demo.study.controller;

import com.example.demo.study.controller.request.FindFruitNameRequest;
import com.example.demo.study.controller.request.FruitRequest;
import com.example.demo.study.entity.Fruit;
import com.example.demo.study.repository.FruitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruit")
@Slf4j
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    // 등록
    @PostMapping("/create")
    public Fruit createFruit(@RequestBody FruitRequest request){
        log.info("createFruit -> request: {}", request);
        Fruit fruit = request.toFruit();
        return fruitRepository.save(fruit);
    }

    // 이름검색
    @PostMapping("/find")
    public Fruit findFruitByName(@RequestBody FindFruitNameRequest request){
        log.info("findFruit -> request: {}", request);

        String fruitName = request.getFruitName();
        Optional<Fruit> maybeFruit = fruitRepository.findByName(fruitName);

        if(maybeFruit.isEmpty()){
            log.info("그런 과일 안팔아요.");
            return null;
        }
        return maybeFruit.get();
    }

    // 삭제
    @GetMapping("/delete")
    public void deleteFruit(@RequestParam Long id){
        log.info("deleteFruit -> id: {}", id);
        fruitRepository.deleteById(id);
    }
    // 수정
    @PostMapping("/update")
    public Fruit updateFruit(@RequestBody FruitRequest request){
        log.info("updateFruit -> request: {}", request);
        Long fruitId = request.getId();

        Optional<Fruit> maybeFruit = fruitRepository.findById(fruitId);
        if(maybeFruit.isEmpty()){
            return request.toFruit();
        }
        Fruit fruit = maybeFruit.get();
        fruit.setPrice(request.getPrice());
        return fruitRepository.save(fruit);
    }

    // 전체 조회
    @GetMapping("/list")
    public List<Fruit> listFruit(){
        log.info("listFruit");
        return fruitRepository.findAll();
    }
    // id로 조회
    @GetMapping("/read/{id}")
    public Fruit readFruit(@PathVariable Long id){
        log.info("readFruit -> id: {}", id);
        Optional<Fruit> maybeFruit = fruitRepository.findById(id);
        if(maybeFruit.isEmpty()){
            return null;
        }
        return maybeFruit.get();
    }
}
