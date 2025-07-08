package com.example.demo.study.user.controller.request;

import com.example.demo.study.user.entity.User;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {
    static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    String userId;
    String password;


    public Boolean checkPassword(String encodedPassword) {
        // 일치하면 참을 리턴
        return encoder.matches(password, encodedPassword);
    }
}
