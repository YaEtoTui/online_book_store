package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksGetRepository extends CrudRepository<Book, String> {

}
