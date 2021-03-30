package ru.otus.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.mvc.model.Book;
import ru.otus.mvc.service.BookService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    @Autowired
    private BookService service;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
    }

    @PostConstruct
    public void init() {
        service.save(new Book("name1", "author1", "genre1"));
        service.save(new Book("name2", "author2", "genre2"));
        service.save(new Book("name3", "author3", "genre3"));
        service.save(new Book("name4", "author4", "genre4"));
    }
}
