package com.k02.book_management.controller;

import com.k02.book_management.dto.AuthorDto;
import com.k02.book_management.model.Author;
import com.k02.book_management.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.net.URI;
import java.util.List;

@RestController // 이 클래스는 레포지토리로 사용하겠다는 의미
@RequestMapping("/api/authors") // api로 부팅한다는 의미 부여
@RequiredArgsConstructor // final로 선언된 필드를 자동으로 생성자 주입 받는 역할
public class AuthorController {
    private final AuthorService authorService;

    // @RequestMapping("/api/authors") 와 겹치지 않게 접속하기 위함
    // ResponseEntity으로 만드는것이 올바른 로직이다.
    @GetMapping //
    public ResponseEntity<List<Author>> list() {
        List<Author> authors = authorService.getAll();

        return ResponseEntity.ok(authors);
    }

    //단일 조회
    @GetMapping("/{id}") //동적 경로
    public ResponseEntity<Author> get(@PathVariable Integer id){
        Author author = authorService.getById(id);

        return ResponseEntity.ok(author);
    }

    // 저장 로직
    @PostMapping //바디에 DTo를 써도 됨
    public ResponseEntity<Author> create(@Valid @RequestBody AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());

        Author saved = authorService.create(author);

        return ResponseEntity.created(URI.create("/api/authors" + saved.getId())).body(saved);
    }

    // 업데이트 로직
    @PutMapping("/{id}")
    public ResponseEntity<Author> update(
            @PathVariable Integer id, // id값을 받아오기
            @Valid @RequestBody AuthorDto authorDto // 바디에 새로운 값을 저장하기
    ){
        Author author = new Author();
        author.setName(authorDto.getName());

        Author updated = authorService.update(id, author);

        return ResponseEntity.ok(updated);
    }

    //삭제 로직
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        authorService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
