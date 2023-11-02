package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.*;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.repository.BooksInCartRepository;
import com.project.online_book_store.app.repository.CartRepository;
import com.project.online_book_store.app.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class CartService {

    BooksInCartRepository booksInCartRepository;
    CartRepository cartRepository;
    BookRepository bookRepository;

    public List<BookResponse> showBooks() {
        List<BookInCart> bookInCartList = booksInCartRepository.findAll();
        return bookInCartList.stream()
                .map(this::createBookResponse)
                .collect(Collectors.toList());
    }

    public BookResponse createBookResponse(BookInCart book) {
        return new BookResponse(
                book.getBook().getId(),
                book.getBook().getName(),
                book.getBook().getPage(),
                book.getBook().getPrice(),
                book.getBook().getCount(),
                createAuthorInfo(book.getBook().getAuthor())
        );
    }

    private BookResponse.AuthorInfo createAuthorInfo(Author author) {
        return new BookResponse.AuthorInfo(
                author.getNameAuthor()
        );
    }

    public void addBookInCart(Long bookId) {
        Cart cart = cartRepository.getReferenceById(100L);
        Book book = bookRepository.getReferenceById(bookId);
        if (booksInCartRepository.findBookInCartsByBookAndCart_Id(book, 100L) != null) {
            BookInCart bookInCart = new BookInCart(book, cart);
            booksInCartRepository.save(bookInCart);
        }
    }

    public void deleteBookInCart(Long bookId) {
        Cart cart = cartRepository.getReferenceById(100L);
        Book book = bookRepository.getReferenceById(bookId);
        BookInCart bookInCart = booksInCartRepository.findBookInCartByBookAndCart(book, cart);
        booksInCartRepository.delete(bookInCart);
    }
}
