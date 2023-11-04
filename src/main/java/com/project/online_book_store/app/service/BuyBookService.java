package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;

import java.util.List;

public interface BuyBookService {

    List<BookResponse> showBooks();

    List<BuyBook> getListBuyBooks();
}
