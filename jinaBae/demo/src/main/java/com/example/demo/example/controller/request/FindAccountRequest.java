package com.example.demo.example.controller.request;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAccountRequest {
    Long accountId;
}
