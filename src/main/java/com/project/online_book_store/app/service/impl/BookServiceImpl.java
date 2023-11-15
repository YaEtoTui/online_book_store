package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.service.BookService;
import com.project.online_book_store.app.service.factory.BookFactory;
import javax.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    BookFactory bookFactory;


    public List<BookResponse> getBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookFactory.createListBookResponse(bookList);
    }
}
