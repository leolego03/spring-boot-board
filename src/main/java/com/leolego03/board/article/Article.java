package com.leolego03.board.article;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Article {
	@Id
	@SequenceGenerator(
					name = "article_sequence",
					sequenceName = "article_sequence",
					allocationSize = 1
	)
	@GeneratedValue(
					strategy = GenerationType.SEQUENCE,
					generator = "article_sequence"
	)
	private Long id;
	private String name;
	private String subject;
	private String content;
	private LocalDate date;
	
	public Article() {
	}

	public Article(String name,
					String subject,
					String content,
					LocalDate date) {
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Article{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", email='" + subject + '\'' +
	            ", email='" + content + '\'' +
	            ", date=" + date +
	            '}';
	}
}
