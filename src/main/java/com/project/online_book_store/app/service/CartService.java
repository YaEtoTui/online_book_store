package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.BookInCart;

import java.util.List;

/* Здесь хранится бизнес логика Сервиса Корзина*/

public interface CartService {

    List<BookInCart> showBooks();

    void addBookInCart(Long bookId);

    void deleteBookInCart(Long bookId);
}
