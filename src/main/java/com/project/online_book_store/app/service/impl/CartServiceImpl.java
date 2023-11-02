package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.domain.entity.Cart;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.repository.BooksInCartRepository;
import com.project.online_book_store.app.repository.CartRepository;
import com.project.online_book_store.app.service.CartService;
import com.project.online_book_store.app.service.factory.CartFactory;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService {

    BooksInCartRepository booksInCartRepository;
    CartRepository cartRepository;
    BookRepository bookRepository;
    CartFactory cartFactory;

    @Override
    public List<BookInCart> showBooks() {
        List<BookInCart> bookInCartList = booksInCartRepository.findAll();
        return bookInCartList;
    }

    @Override
    public void addBookInCart(Long bookId) {
        Cart cart = cartRepository.getReferenceById(100L);
        Book book = bookRepository.getReferenceById(bookId);
        if (booksInCartRepository.findBookInCartsByBookAndCart_Id(book, 100L) != null) {
            BookInCart bookInCart = new BookInCart(book, cart);
            booksInCartRepository.save(bookInCart);
        }
    }

    @Override
    public void deleteBookInCart(Long bookId) {
        BookInCart bookInCart = booksInCartRepository.getReferenceById(bookId);
        booksInCartRepository.delete(bookInCart);
    }
}
