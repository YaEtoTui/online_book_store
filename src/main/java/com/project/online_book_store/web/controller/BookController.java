package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.common.exception.NotFoundBookException;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.service.BookService;
import com.project.online_book_store.app.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookController {

    BookService bookService;
    CartService cartService;
    BookRepository bookRepository;

    @ModelAttribute("listBooks")
    public List<BookResponse> listBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/")
    public String getMainPage(Model model){
        Boolean isAuthenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        model.addAttribute("isAuthenticated", isAuthenticated);
        model.addAttribute("countBooks", cartService.showBooks().size());
        return "main";
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
