package ru.otus.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.mvc.dao.BookRepository;
import ru.otus.mvc.model.Book;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteBook(int id) {
        repository.deleteById(id);
    }

    @Override
    public Book getBook(int id) {
        return repository.findById(id);
    }
}
