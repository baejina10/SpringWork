package com.example.demo.study.repository;

import com.example.demo.study.entity.SamplePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamplePostRepository extends JpaRepository<SamplePost,Long> {
}
