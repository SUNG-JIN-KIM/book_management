package com.k02.book_management.controller;

import com.k02.book_management.dto.BookDto;
import com.k02.book_management.model.Book;
import com.k02.book_management.service.BookService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> list(){
        List<Book> book = bookService.getAll();

        return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id){
        Book book = bookService.getById(id);

        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookDto bookDto){
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthorId(bookDto.getAuthorId());

        Book savedBook = bookService.create(book);

        URI location = URI.create("/api/books/" + savedBook.getId());

        return ResponseEntity.created(location).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @Valid @RequestBody BookDto bookDto){
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthorId(bookDto.getAuthorId());

        Book updated = bookService.update(id, book);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        bookService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
