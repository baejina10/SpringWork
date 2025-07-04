package com.example.demo.controller;

import com.example.demo.controller.request.SamplePostRequest;
import com.example.demo.entity.SamplePost;
import com.example.demo.repository.SamplePostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SamplePostController {

    // 생성, 수정, 삭제, 조회, 전체 조회
    @Autowired
    SamplePostRepository samplePostRepository;
    //생성
    @PostMapping("samplePost/create")
    public SamplePost create(@RequestBody SamplePostRequest request){
        log.info("createSamplePost -> request: {}", request);
        SamplePost samplePostRequest = request.toSamplePost();

        return samplePostRepository.save(samplePostRequest);
    }

    // 수정

    // 삭제

    // 조회

    // 전체 조회

}
