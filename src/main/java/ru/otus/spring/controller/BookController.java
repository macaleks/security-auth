package ru.otus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.otus.spring.model.Book;
import ru.otus.spring.service.BookService;


import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "main";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") int id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping("/edit")
    public ModelAndView saveBook(Book book, ModelMap model) {
        Book saved = bookService.save(book);
        model.addAttribute("id", saved.getId());
        return new ModelAndView("redirect:/edit", model);
    }

    @GetMapping("/delete")
    public String deletePage(@RequestParam("id") int id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "edit";
    }
}
