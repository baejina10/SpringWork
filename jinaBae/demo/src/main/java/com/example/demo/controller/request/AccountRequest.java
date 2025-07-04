package com.example.demo.controller.request;

import com.example.demo.entity.Account;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    String userId;
    String password;

    public Account toAccount() {
        return new Account(userId, password);
    }
}
