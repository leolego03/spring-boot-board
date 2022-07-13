package com.leolego03.board.article;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleService {
	
	private final ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	public List<Article> getArticles() {
		return articleRepository.findAll();
	}

	public void addNewArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	public void deleteArticle(Long articleId) {
		// TODO Auto-generated method stub
		
	}

	public void updateArticle(Long articleId, String name, String subject, String content, LocalDate date) {
		// TODO Auto-generated method stub
		
	}
}
