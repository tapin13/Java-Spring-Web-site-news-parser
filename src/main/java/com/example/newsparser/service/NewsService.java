package com.example.newsparser.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.newsparser.model.News;

@Service
public interface NewsService {
	public void save(News news);
	public boolean isExist(String title);
	public List<News> getAllNews();
}
