package com.leolego03.board.article;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
		articleRepository.save(article);
	}

	public void deleteArticle(Long articleId) {
		boolean exists = articleRepository.existsById(articleId);
		if (!exists) {
				throw new IllegalStateException(
								"article with id " + articleId + " does not exists");
		}
		articleRepository.deleteById(articleId);
	}

	@Transactional
	public void updateArticle(Long articleId,
								String name,
								String subject,
								String content,
								LocalDate date) {
		Article article = articleRepository.findById(articleId)
							.orElseThrow(() -> new IllegalStateException(
											"article with id " + articleId + " does not exists"));
		
		if (name != null &&
						name.length() > 0 &&
						!Objects.equals(article.getName(), name)) {
				article.setName(name);
		}
		
		if (subject != null &&
				subject.length() > 0 &&
				!Objects.equals(article.getSubject(), subject)) {
		article.setSubject(subject);
		}
		
		if (content != null &&
				content.length() > 0 &&
				!Objects.equals(article.getContent(), content)) {
		article.setContent(content);
		}
		
	}
}
