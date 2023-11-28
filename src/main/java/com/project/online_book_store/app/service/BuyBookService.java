package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.BuyBook;

import java.util.List;

/* Здесь хранится бизнес логика Сервиса "Купленные книги"*/

public interface BuyBookService {
    List<BuyBook> getListBuyBooks();
}
