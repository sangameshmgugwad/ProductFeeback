package com.target.product.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProductFeedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductFeedbackApplication.class, args);
	}
}
