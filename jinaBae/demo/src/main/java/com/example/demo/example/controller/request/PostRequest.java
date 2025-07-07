package com.example.demo.example.controller.request;

import com.example.demo.example.entity.Post;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    String title;
    String content;

    public Post toPost() {
        return new Post(title,content);
    }
}
