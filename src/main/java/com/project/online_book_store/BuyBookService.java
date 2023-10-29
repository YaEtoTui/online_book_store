package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuyBookService {

    @Autowired
    private BuyBookRepository buyBookRepository;
    @Autowired
    private  BooksGetRepository booksGetRepository;

    public BuyBook buyOneBook(String name, Integer count){
        Book book = new Book();
        name = book.getName();
        booksGetRepository.findById(name);
        BuyBook buyBook = new BuyBook();
        buyBook.setBook(book);
        buyBook.setCount(count);
        return buyBookRepository.save(buyBook);
    }
}
