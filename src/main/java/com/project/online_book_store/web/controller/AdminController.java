package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.dto.CreateRequestBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.service.AdminService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/* Админка. Здесь эндпоинты для добавления новых книг, изображений для них т.д.*/


@RestController
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AdminController {

    AdminService adminService;

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
}
