package com.example.demo.example.controller;

import com.example.demo.example.controller.request.SamplePostRequest;
import com.example.demo.example.entity.SamplePost;
import com.example.demo.example.repository.SamplePostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("samplePost/update")
    public SamplePost update(@RequestBody SamplePostRequest request){
        log.info("updateSamplePost -> request: {}", request);
        Long sampleId = request.getSamplePostId();
        Optional<SamplePost> maybeSamplePost = samplePostRepository.findById(sampleId);

        if(maybeSamplePost.isEmpty()){
            return null;
        }
        SamplePost foundSamplePost = maybeSamplePost.get();
        foundSamplePost.setTitle(request.getTitle());
        foundSamplePost.setContent(request.getContent());

        return samplePostRepository.save(foundSamplePost);
    }

    // 삭제
    @GetMapping("samplePost/delete")
    public void delete(@RequestParam Long samplePostId){
        log.info("deleteSamplePost -> samplePostId: {}", samplePostId);
        samplePostRepository.deleteById(samplePostId);
    }
    // 조회 1
    @PostMapping("samplePost/read")
    public SamplePost read(@RequestBody SamplePostRequest request){
        log.info("readSamplePost -> request: {}", request);
        Long sampleId = request.getSamplePostId();

        Optional<SamplePost> maybeSamplePost = samplePostRepository.findById(sampleId);
        if(maybeSamplePost.isEmpty()){
            return null;
        }
        return maybeSamplePost.get();

    }
    // 조회 2
    @GetMapping("samplePost/read/{id}")
    public SamplePost idRead(@PathVariable Long id){
        log.info("readSamplePost -> id: {}", id);
        Optional<SamplePost> maybeSamplePost = samplePostRepository.findById(id);
        if (maybeSamplePost.isEmpty()){
            return null;
        }
        return maybeSamplePost.get();

    }

    // 전체 조회
    @GetMapping("samplePost/list")
    public List<SamplePost> list(){
        log.info("listSamplePost");
        return samplePostRepository.findAll();
    }

}
