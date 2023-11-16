package com.project.online_book_store.app.service.factory;

import com.project.online_book_store.app.common.exception.NotFoundBookException;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.repository.BuyBookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

/* Здесь ищем путь изображений */

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ImageFactory {

    BuyBookRepository buyBookRepository;
    BookRepository bookRepository;

    public Path checkImagePathWithBuyBook(Long buyBookId) {
        BuyBook book = buyBookRepository.findById(buyBookId)
                .orElseThrow(() -> new NotFoundBookException(
                                String.format("Not found id '%s' book", buyBookId)
                        )
                );
        return Paths.get(book.getPathImage());
    }

    public Path checkImagePathWithBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundBookException(
                                String.format("Not found id '%s' book", bookId)
                        )
                );
        return Paths.get(book.getPathImage());
    }
}
