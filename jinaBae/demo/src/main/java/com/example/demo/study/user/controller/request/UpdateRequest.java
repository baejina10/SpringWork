package com.example.demo.study.user.controller.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequest {
    String userId;
    String password;
}
