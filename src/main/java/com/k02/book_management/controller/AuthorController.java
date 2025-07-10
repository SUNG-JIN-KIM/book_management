package com.k02.book_management.controller;

import com.k02.book_management.dto.AuthorDto;
import com.k02.book_management.model.Author;
import com.k02.book_management.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스는 레포지토리로 사용하겠다는 의미
@RequestMapping("/api/authors")
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 주입 받는 역할
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping //바디에 DTo를 써도 됨
    public Author create(@Valid @RequestBody AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());

        return authorService.create(author);
    }
}
