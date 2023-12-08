package com.project.online_book_store.app.service.factory;

import com.project.online_book_store.app.domain.entity.Author;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.domain.entity.dto.response.BookWithDescriptionResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/* Здесь мы создаем, переделываем объекты, нужные для дальнейшего использования */

@Component
public class BookFactory {

    //Переделываем список объектов класса Book в список BookResponse
    public List<BookResponse> createListBookResponse(List<Book> bookList) {
        return bookList.stream()
                .map(this::createBookResponse)
                .collect(Collectors.toList());
    }

    //Переделываем объект класса Book в BookResponse
    public BookResponse createBookResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getName(),
                book.getPage(),
                book.getPrice(),
                book.getCount(),
                book.getPathImage(),
                createAuthorInfo(book.getAuthor())
        );
    }

    //Создаем Класс AuthorInfo
    private BookResponse.AuthorInfo createAuthorInfo(Author author) {
        return new BookResponse.AuthorInfo(
                author.getNameAuthor()
        );
    }

    //Переделываем объект класса Book в BookWithDescriptionResponse
    public BookWithDescriptionResponse createBookWithDescriptionResponse(Book book) {
        return new BookWithDescriptionResponse(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getPage(),
                book.getPrice(),
                book.getCount(),
                book.getPathImage(),
                createAuthorInfo(book.getAuthor())
        );
    }
}
