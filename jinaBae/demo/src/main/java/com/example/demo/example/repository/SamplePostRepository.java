package com.example.demo.example.repository;

import com.example.demo.example.entity.SamplePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamplePostRepository extends JpaRepository<SamplePost,Long> {
}
