package com.project.online_book_store.web.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Контроллер для выхода из аккаунта*/


@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api")
public class LogOutController {

    //Эндпоинт выводит html-страницу Logout
    @PostMapping("/logout")
    public String openLoginPage() {
        return "redirect:/api/";
    }
}
