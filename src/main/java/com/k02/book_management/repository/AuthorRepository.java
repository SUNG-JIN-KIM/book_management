package com.k02.book_management.repository;


import com.k02.book_management.model.Author;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AuthorRepository {
    private final Map<Integer, Author> store = new LinkedHashMap<>();
    private final AtomicInteger seq = new AtomicInteger(0);

    // 등록된 작사 리스트로 보이게 하기 위한 로직
    public List<Author> findAll() {
        return new ArrayList<>(store.values());
    }

    //단일 조회하기 위한 로직
    public Optional<Author> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    public Author save(Author author) {
        if (author.getId() == null) {
            author.setId(seq.incrementAndGet());
        }
        store.put(author.getId(), author);

        return author;
    }

//    // 업데이트 로직
//    public Author update(Integer id, Author updatedAuthor) {
//        if (!store.containsKey(id)) {
//            throw new NoSuchElementException(id +"의 저자가 없습니다");
//        }
//
//        updatedAuthor.setId(id);
//        store.put(id, updatedAuthor);
//
//        return updatedAuthor;
//    }

    //삭제 로직
    public void delete(Integer id){
        store.remove(id);
    }