package com.leolego03.board.article;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/article")
public class ArticleController {
		
		private final ArticleService articleService;
		
		@Autowired
		public ArticleController(ArticleService articleService) {
			this.articleService = articleService;
		}
		
		@GetMapping(path = "{articleId}")
		public Article getArticle(
		        @PathVariable("articleId") Long articleId) {
		   return articleService.getArticle(articleId);
		}
		
		
		@GetMapping
		public List<Article> getArticles() {
			return articleService.getArticles();
		}
		
		@PostMapping
		public void registerNewArticle(@RequestBody Article article) {
			articleService.addNewArticle(article);
		}
		
		@DeleteMapping(path = "{articleId}")
		public void deleteArticle(
				@PathVariable("articleId") Long articleId) {
			articleService.deleteArticle(articleId);
		}
		
		@PutMapping(path = "{articleId}")
		public void updateArticle(
				@PathVariable("articleId") Long articleId,
				@RequestParam(required = false) String name,
				@RequestParam(required = false) String subject,
				@RequestParam(required = false) String content,
				@RequestParam(required = false) LocalDate date) {
			articleService.updateArticle(articleId, name, subject, content, date);
		}
}
