package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class GetBooksController {

    public GetBooksService getBooksService;

    @GetMapping(path = "/{name}")
    public List<Book> getBooks(){

        return getBooksService.getBooks();
    }
}
