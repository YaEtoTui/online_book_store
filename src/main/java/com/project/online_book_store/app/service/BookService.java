package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.domain.entity.dto.response.BookWithDescriptionResponse;

import java.util.List;

public interface BookService {

    List<BookResponse> getBooks();

    BookWithDescriptionResponse getBookById(Long bookId);
}
