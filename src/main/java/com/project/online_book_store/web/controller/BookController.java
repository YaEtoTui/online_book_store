package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BookController {

    BookService bookService;

    @ModelAttribute("listBooks")
    public List<BookResponse> listBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/")
    public String getMainPage(){
        return "main";
    }
}
