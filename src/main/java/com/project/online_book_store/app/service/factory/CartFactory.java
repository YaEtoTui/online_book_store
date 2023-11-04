package com.project.online_book_store.app.service.factory;

import com.project.online_book_store.app.domain.entity.Author;
import com.project.online_book_store.app.domain.entity.BookInCart;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartFactory {

    public List<BookResponse> createBookListResponse(List<BookInCart> bookInCartList) {
        return bookInCartList.stream()
                .map(this::createBookResponse)
                .collect(Collectors.toList());
    }

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

    private BookResponse.AuthorInfo createAuthorInfo(Author author) {
        return new BookResponse.AuthorInfo(
                author.getNameAuthor()
        );
    }
}
