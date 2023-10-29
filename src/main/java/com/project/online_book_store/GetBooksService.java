package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetBooksService {

    @Autowired
    private BooksGetRepository booksGetRepository;

    public List<Book> getBooks(){
        List<Book> allBooks = new ArrayList<>();
        booksGetRepository.findAll().forEach(book -> allBooks.add(book));
        return allBooks;
    }
}
