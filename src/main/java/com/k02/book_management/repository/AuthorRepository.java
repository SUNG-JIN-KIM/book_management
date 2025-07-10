package com.k02.book_management.repository;


import com.k02.book_management.model.Author;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AuthorRepository {
    private final Map<Integer, Author> store = new LinkedHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(seq.incrementAndGet());
        }
        store.put(author.getId(), author);

        return author;
    }

    }