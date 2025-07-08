package com.example.demo.study.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 이것을 가지고 회원가입, 로그인, 탈퇴, 비밀 번호 변경
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userId;
    String password;
    String nickName;
    String email;

    public User(String userId, String password, String nickName, String email) {
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
    }
}
