package com.example.demo.controller.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
