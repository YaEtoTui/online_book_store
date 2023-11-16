package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.common.exception.NotFoundBookException;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.repository.BookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
* Контроллер для выведения изображений книг на страницах
* */

@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ImageController {

    BookRepository bookRepository;

    @GetMapping("/image/{id}")
    @SneakyThrows
    public ResponseEntity<?> uploadImage(@PathVariable("id") Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundBookException(
                                String.format("Not found id '%s' book", id)
                        )
                );
        Path path = Paths.get(book.getPathImage());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new UrlResource(path.toUri()));
    }
}
