package com.project.online_book_store.app.service.factory;

import com.project.online_book_store.app.domain.entity.Author;
import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/* Здесь мы создаем, переделываем объекты, нужные для дальнейшего использования */

@Component
public class CartFactory {

    //Переделываем список объектов класса BookInCart в список BookResponse
    public List<BookResponse> createBookListResponse(List<BookInCart> bookInCartList) {
        return bookInCartList.stream()
                .map(this::createBookResponse)
                .collect(Collectors.toList());
    }

    //Переделываем объект класса BookInCart в BookResponse
    private BookResponse createBookResponse(BookInCart book) {
        return new BookResponse(
                book.getBook().getId(),
                book.getBook().getName(),
                book.getBook().getPage(),
                book.getBook().getPrice(),
                book.getBook().getCount(),
                book.getBook().getPathImage(),
                createAuthorInfo(book.getBook().getAuthor())
        );
    }

    //Создаем Класс AuthorInfo
    private BookResponse.AuthorInfo createAuthorInfo(Author author) {
        return new BookResponse.AuthorInfo(
                author.getNameAuthor()
        );
    }
}
