package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void deleteBook(Long id);
}
