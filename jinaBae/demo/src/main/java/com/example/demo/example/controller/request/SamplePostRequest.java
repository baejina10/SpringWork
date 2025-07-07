package com.example.demo.example.controller.request;

import com.example.demo.example.entity.SamplePost;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SamplePostRequest {
    Long samplePostId;
    String title;
    String content;
    String writer;

    public SamplePost toSamplePost(){
        return new SamplePost(title,content,writer);
    }
}
