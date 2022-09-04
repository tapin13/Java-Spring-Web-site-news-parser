package com.example.newsparser.job;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.newsparser.model.News;
import com.example.newsparser.service.NewsService;

@Component
public class ParseTask {

	@Value("${parse.site.url}")
	String url;
	
	@Value("${parse.title.link}")
	String titleLink;
	
	@Autowired
	NewsService newsService;
	
	@Scheduled(fixedDelay = 10000)
	public void ParseNewNews() {
		try {
			Document doc = Jsoup.connect(url)
					.timeout(5000)
					.get();
			Elements siteNews = doc.getElementsByClass(titleLink);
			for(Element element: siteNews) {
				String title = element.ownText();
				if(!newsService.isExist(title)) {
					News news = new News();
					news.setTitle(title);
					newsService.save(news);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
