package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.common.exception.NotFoundBookException;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.dto.CreateRequestBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.service.AdminService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AdminController {

    AdminService adminService;
    BookRepository bookRepository;

    @PostMapping("/uploadImage/image/{imageId}")
    public ResponseEntity<BookResponse> uploadImage(@PathVariable("imageId") Long imageId, @RequestParam MultipartFile image) {
        return ResponseEntity.ok()
                .body(adminService.uploadImage(imageId, image));
    }

    @PostMapping("/request/book")
    public ResponseEntity<BookResponse> addNewBook(@RequestBody CreateRequestBook createRequestBook) {
        return ResponseEntity.ok()
                .body(adminService.addNewBook(createRequestBook));
    }

    @DeleteMapping("/request/delete/{bookId}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable("bookId") Long bookId) {
        return ResponseEntity.ok()
                .body(adminService.deleteBook(bookId));
    }

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
