package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Book saveBook(Book book) {
        if (book.getPublisher() != null && book.getPublisher().getId() != null) {
            Publisher publisher = publisherRepository.findById(book.getPublisher().getId())
                                    .orElseThrow(() -> new RuntimeException("Publisher not found"));
            book.setPublisher(publisher); // Ensure managed entity
        }
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
