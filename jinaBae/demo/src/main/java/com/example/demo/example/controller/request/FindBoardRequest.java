package com.example.demo.example.controller.request;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
// Getter 사용 시 클래스 내부의 멤버 변수를 아래와 같이 구성해야 합니다.
// Long id -> getId(()
// Long boardId -> getBoardId()
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindBoardRequest {
    Long boardId;
}
