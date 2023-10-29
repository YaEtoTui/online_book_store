package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Buy;
import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyAllBooksRepositiry extends CrudRepository<BuyBook, String> {
}
