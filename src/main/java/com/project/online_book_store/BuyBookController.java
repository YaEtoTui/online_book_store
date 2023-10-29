package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy-books")
public class BuyBookController {

    private BuyBookService buyBookService;

    @PostMapping(path = "/{name}")
    public BuyBook buyOneBook(Book book) {
        BuyBook updatedBuyBook = buyBookService.buyOneBook(book.name, book.count);
        return updatedBuyBook;
    }
}