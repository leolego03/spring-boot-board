package com.leolego03.board.article;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import static java.time.Month.*;
import java.util.List;

@Configuration
public class ArticleConfig {

		@Bean
		CommandLineRunner commandLineRunner(
						ArticleRepository articleRepository) {
				return args -> {
						Article arti01 = new Article(
										"user01",
										"practicing swimming using snorkels",
										"If you use snorkel, you can swim while focusing on your arm movements.",
										LocalDate.of(2022, JULY, 12)
						);
						
						articleRepository.saveAll(
								List.of(arti01)
						);
				};
		}
}