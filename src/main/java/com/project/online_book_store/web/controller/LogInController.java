package com.project.online_book_store.web.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Контроллер для перехода на страницу авторизации*/

@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class LogInController {

    //Эндпоинт выводит html-страницу Login
    @GetMapping("/login")
    public String openLoginPage() {
        return "/login";
    }
}
