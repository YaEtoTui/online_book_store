package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyBookRepository extends CrudRepository<BuyBook, Book> {
}
