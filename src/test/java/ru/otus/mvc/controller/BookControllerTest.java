package ru.otus.mvc.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.mvc.model.Book;
import ru.otus.mvc.service.BookService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService service;

    Book book = new Book(1, "name", "author", "genre");

    @Test
    public void testGetEdit() throws Exception {
        given(service.getBook(1)).willReturn(book);
        mvc.perform(get("/edit?id=1")).andExpect(status().isOk());
        verify(service).getBook(1);
    }

    @Test
    public void testPostEdit() throws Exception {
        when(service.save(any())).thenReturn(book);
        mvc.perform(post("/edit?id=1")).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/edit?id=1"));
    }

    @Test
    public void testGetDelete() throws Exception {
        given(service.getBook(1)).willReturn(book);
        mvc.perform(get("/delete?id=1")).andExpect(status().isOk());
        verify(service).getBook(1);
    }

    @Test
    public void testPostDelete() throws Exception {
        doNothing().when(service).deleteBook(1);
        mvc.perform(post("/delete?id=1")).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
        verify(service).deleteBook(1);
    }

    @Test
    public void testMain() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
        verify(service).findAll();
    }
}
