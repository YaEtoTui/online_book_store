package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/* Контроллер для перехода на страницу "Главная", где отображаются все книги */


@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MainPageController {

    BookService bookService;
    AccountRepository accountRepository;

    @ModelAttribute("listBooks")
    public List<BookResponse> listBooks(){
        return bookService.getBooks();
    }

    @GetMapping({"/", "/api"})
    public String getMainPage(Model model){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findAccountByUsername(username);
        if (account != null) {
            model.addAttribute("isAuthenticated", false);
            model.addAttribute("countBooks", account.getClient().getCart().getBookInCartList().size());
        } else {
            model.addAttribute("isAuthenticated", true);
            model.addAttribute("countBooks", 0);
        }
        return "main";
    }
}
