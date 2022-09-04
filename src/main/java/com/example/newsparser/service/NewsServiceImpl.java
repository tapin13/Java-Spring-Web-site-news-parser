package com.example.newsparser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newsparser.model.News;
import com.example.newsparser.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsRepository repository;

	@Override
	public void save(News news) {
		repository.save(news);
	}

	@Override
	public boolean isExist(String title) {
		List<News> news = repository.findAll();
		for(News article: news) {
			if(article.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<News> getAllNews() {
		return repository.findAll();
	}

}
