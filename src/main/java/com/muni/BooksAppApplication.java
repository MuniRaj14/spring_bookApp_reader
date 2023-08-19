package com.muni;

import com.muni.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BooksAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BooksAppApplication.class, args);

		BookService bookService = context.getBean(BookService.class);
		bookService.processBooks();
	}

}
