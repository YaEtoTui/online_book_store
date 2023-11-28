package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Репозиторий "Книга в корзине", связующий сервиса и бд, где получаем необходимую сущность "Книга в корзине"*/

@Repository
public interface BooksInCartRepository extends JpaRepository<BookInCart, Long> {

    List<BookInCart> findBookInCartsByBookAndCart_Id(Book book, Long cartId);
    BookInCart findBookInCartByBookAndCart(Book book, Cart cart);
}
