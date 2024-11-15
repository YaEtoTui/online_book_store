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

/* Здесь мы создаем, переделываем объекты, нужные для дальнейшего использования */

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ImageFactory {

    BuyBookRepository buyBookRepository;
    BookRepository bookRepository;

    //Проверяем, что путь до изображения есть в БД для вывода самого изображения
    public String checkImagePathWithBuyBook(Long buyBookId) {
        BuyBook book = buyBookRepository.findById(buyBookId)
                .orElseThrow(() -> new NotFoundBookException(
                                String.format("Not found id '%s' book", buyBookId)
                        )
                );
        return book.getPathImage();
    }

    //Проверяем, что путь до изображения есть в БД для вывода самого изображения
    public String checkImagePathWithBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundBookException(
                                String.format("Not found id '%s' book", bookId)
                        )
                );
        return book.getPathImage();
    }
}
