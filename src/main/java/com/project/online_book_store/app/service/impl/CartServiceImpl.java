package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.repository.BooksInCartRepository;
import com.project.online_book_store.app.repository.CartRepository;
import com.project.online_book_store.app.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/* Сервис по корзине*/

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements CartService {

    BooksInCartRepository booksInCartRepository;
    BookRepository bookRepository;
    AccountRepository accountRepository;

    //Получаем список книг, которые находятся в корзине
    @Override
    public List<BookInCart> showBooks() {
        return booksInCartRepository.findAll();
    }

    //Метод добавления книги в корзину по его id
    @Override
    public void addBookInCart(Long bookId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findAccountByUsername(username);
        Book book = bookRepository.getReferenceById(bookId);

        List<BookInCart> bookInCartList = booksInCartRepository.findBookInCartsByBookAndCart_Id(book, account.getClient().getCart().getId());

        if (bookInCartList.isEmpty()) {
            BookInCart bookInCart = new BookInCart(book, account.getClient().getCart());
            booksInCartRepository.save(bookInCart);
        }
    }

    //Метод удаления книги из корзины по его id
    @Override
    public void deleteBookInCart(Long bookId) {
        BookInCart bookInCart = booksInCartRepository.getReferenceById(bookId);
        booksInCartRepository.delete(bookInCart);
    }
}
