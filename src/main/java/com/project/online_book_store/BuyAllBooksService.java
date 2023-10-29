package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.Buy;
import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyAllBooksService {

    @Autowired
    private BuyAllBooksRepositiry buyAllBooksRepositiry;

    public List<BuyBook> buyAllBooks(){
        List<BuyBook> allBuyingBooks = new ArrayList<>();
        buyAllBooksRepositiry.findAll().forEach(buyBook -> allBuyingBooks.add(buyBook));
        return allBuyingBooks;
    }
}
