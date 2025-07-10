package com.k02.book_management.service;

import com.k02.book_management.model.Author;
import com.k02.book_management.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository; // 레포지 토리 불러오기

    }

    public Author update(Integer id, Author updateAuthor){
        getById(id);
        updateAuthor.setId(id);

        return authorRepository.save(updateAuthor);
    }

    // 삭제 로직
    public void delete(Integer id){
        authorRepository.delete(id);
    }

}
