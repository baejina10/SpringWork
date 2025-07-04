package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
// @Entity의 경우 Spring JPA가 자동으로 db 테이블을 생성해줍니다.
@Entity
//lombok에서 지원
@Getter //get으로 시작하는 메서드를 전부 자동화 /getTitle(),getContent()
@Setter //set으로 시작하는 메서드를 전부 자동화 /setTitle(), setContent()
@ToString // java에서는 작성한 클래스 내용을 확인하기 위한 용도로 내부에 toString() 메서드 작성
          // 클래스 내부의 내용을 출력하기 위한 용도로 사용하며 자동화 출력
@NoArgsConstructor // No Argument(인자 없음) Constructor(생성자) : 경우에 따라서 new Post()를 할 수도 있기 때문에 구성
@AllArgsConstructor // AllArgs(모든인자) Constructor(생성자) : new Post("title","content")와 같은 형태의
                    // Post 인스턴스(객체) 생성하기 위해 사용
public class Post {
    // Long id에 해당하는 필드가 unique 및 pk가 되도록 생성
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;
    String title;
    String content;
    /*
    C:\proj\CodeMasters\demo\src\main\java\com\example\demo\controller\PostController.java:30: error: no suitable constructor found for Post(String,String)
        Post createdPost = new Post("제목","내용"); //post 객체가 '제목','내용'으로 만들어져 createdpost 에 정보저장
                           ^
    constructor Post.Post() is not applicable
      (actual and formal argument lists differ in length)
    constructor Post.Post(Long,String,String) is not applicable
      (actual and formal argument lists differ in length)

      위와 같은 에러가 발생할 수 있기 때문에 별도의 생성자를 작성해야 합니다.
      Alt+ Insert로 생성자를 자동화합니다.
     */

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
