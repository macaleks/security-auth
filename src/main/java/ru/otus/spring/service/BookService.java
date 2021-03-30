package ru.otus.spring.service;


import ru.otus.spring.model.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    void deleteBook(int id);

    Book getBook(int id);
}
