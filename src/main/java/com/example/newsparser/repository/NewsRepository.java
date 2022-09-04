package com.example.newsparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.newsparser.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
