package ru.otus.mvc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.mvc.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();
    Book findById(int id);
    Book save(Book book);
    void deleteById(int id);
}