package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buy-all-books")
public class BuyAllBooksController {

    private BuyAllBooksService buyAllBooksService;

    @GetMapping
    public List<BuyBook> buyAllBooks(){
        return buyAllBooksService.buyAllBooks();
    }
}
