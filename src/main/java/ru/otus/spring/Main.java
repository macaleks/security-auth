package ru.otus.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.otus.spring.model.Book;
import ru.otus.spring.security.user.User;
import ru.otus.spring.service.BookService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main {

    @Autowired
    private BookService service;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @PostConstruct
    public void init() {
        service.save(new Book("name1", "author1", "genre1"));
        service.save(new Book("name2", "author2", "genre2"));
        service.save(new Book("name3", "author3", "genre3"));
        service.save(new Book("name4", "author4", "genre4"));
    }

    @Bean
    public List<User> users() {
        return Arrays.asList(new User("reader1", "ps144"), new User("reader2", "psp223"), new User("admin", "admin"));
    }
}
