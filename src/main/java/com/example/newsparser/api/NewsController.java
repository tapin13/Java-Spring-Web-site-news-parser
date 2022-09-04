package com.example.newsparser.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.newsparser.model.News;
import com.example.newsparser.service.NewsService;

@RestController
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@GetMapping(value = "/news")
	public List<News> getAllNews() {
		return newsService.getAllNews();
	}
}
