package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.service.ImageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* Контроллер для выведения изображений книг на страницах
* */

@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ImageController {

    ImageService imageService;

    @GetMapping("/image/buyBook/{id}")
    @SneakyThrows
    public ResponseEntity<?> uploadImageBuyBook(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageService.getImageBuyBook(id));
    }

    @GetMapping("/image/{id}")
    @SneakyThrows
    public ResponseEntity<?> uploadImageBook(@PathVariable("id") Long id) {

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageService.getImageBook(id));
    }
}
