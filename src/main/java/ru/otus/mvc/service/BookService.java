package ru.otus.mvc.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import ru.otus.mvc.model.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    void deleteBook(int id);

    Book getBook(int id);
}
