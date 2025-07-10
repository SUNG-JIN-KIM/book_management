package com.k02.book_management.service;

import com.k02.book_management.model.Author;
import com.k02.book_management.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository; // 레포지 토리 불러오기

    public Author create(Author author){
        return authorRepository.save(author);
    }
}
