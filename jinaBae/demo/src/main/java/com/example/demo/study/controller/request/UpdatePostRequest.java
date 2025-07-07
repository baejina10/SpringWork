package com.example.demo.study.controller.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePostRequest {
    Long postId;
    String title;
    String content;
}
