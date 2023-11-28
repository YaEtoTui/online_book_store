package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.*;
import com.project.online_book_store.app.repository.*;
import com.project.online_book_store.app.service.OrdersService;
import javax.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Сервис по созданию заказов */

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class OrdersServiceImpl implements OrdersService {

    CartRepository cartRepository;
    BookRepository bookRepository;
    BooksInCartRepository booksInCartRepository;
    BuyBookRepository buyBookRepository;
    AccountRepository accountRepository;
    OrderRepository orderRepository;

    @Override
    public void createOrder(Long cartId) {

        Cart cart = cartRepository.getReferenceById(cartId);
        List<BookInCart> bookInCartList = cart.getBookInCartList();

        Order order = new Order(
                cart.getClient().getBuy(),
                new LinkedList<>()
        );

        Order orderEntity = orderRepository.save(order);


        for(int i = 0; i < bookInCartList.size(); i++) {
            BookInCart bookInCart = bookInCartList.get(i);
            Book book = bookInCart.getBook();
            book.setCount(book.getCount() - 1);


            BuyBook buyBook = new BuyBook(
                    book.getName(),
                    book.getAuthor().getNameAuthor(),
                    book.getPathImage(),
                    orderEntity,
                    cart.getClient()
            );

            buyBookRepository.save(buyBook);

            bookRepository.save(book);
            booksInCartRepository.delete(bookInCart);
        }
    }

    public Map<Long, List<BuyBook>> createMapListOrders() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findAccountByUsername(username);

        List<BuyBook> buyBookList = buyBookRepository.findBuyBooksByClient_Id(account.getClient().getId());

        return buyBookList.stream().collect(Collectors.groupingBy((BuyBook buyBook) -> {return  buyBook.getOrder().getId();}));

    }
}
