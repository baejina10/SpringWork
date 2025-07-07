package com.example.demo.example.repository;

import com.example.demo.example.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA를 사용해서 DB를 자동화 하는 이유
//무조건 아래와 같이 extends JpaRepository<Entity, Long> 형태를 추가하면 됩니다.
public interface PostRepository extends JpaRepository<Post, Long> {
}
