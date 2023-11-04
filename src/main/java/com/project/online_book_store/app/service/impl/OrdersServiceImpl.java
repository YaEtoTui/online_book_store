package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.*;
import com.project.online_book_store.app.repository.*;
import com.project.online_book_store.app.service.OrdersService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class OrdersServiceImpl implements OrdersService {

    CartRepository cartRepository;
    BookRepository bookRepository;
    BooksInCartRepository booksInCartRepository;
    BuyBookRepository buyBookRepository;

    @Override
    public void createOrder(Long cartId) {

        Cart cart = cartRepository.getReferenceById(cartId);
        List<BookInCart> bookInCartList = cart.getBookInCartList();


        for(int i = 0; i < bookInCartList.size(); i++) {
            BookInCart bookInCart = bookInCartList.get(i);
            Book book = bookInCart.getBook();
            book.setCount(book.getCount() - 1);

            BuyBook buyBook = new BuyBook(
                    book.getName(),
                    book.getPathImage(),
                    cart.getClient().getBuy()
            );

            buyBookRepository.save(buyBook);

            bookRepository.save(book);
            booksInCartRepository.delete(bookInCart);
        }


    }
}
