package com.k02.book_management.service;

import com.k02.book_management.model.Book;
import com.k02.book_management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("책 없음"));
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Integer id, Book updateBook){
        getById(id);
        updateBook.setId(id);

        return bookRepository.save(updateBook);
    }
    public void delete(Integer id){
        bookRepository.delete(id);
    }
}