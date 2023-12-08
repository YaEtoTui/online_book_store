package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.Buy;
import com.project.online_book_store.app.domain.entity.Cart;
import com.project.online_book_store.app.domain.entity.Client;
import com.project.online_book_store.app.domain.entity.context.AccountContext;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestRegisterForm;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.repository.BuyRepository;
import com.project.online_book_store.app.repository.CartRepository;
import com.project.online_book_store.app.repository.ClientRepository;
import com.project.online_book_store.app.service.RegisterService;
import com.project.online_book_store.app.service.factory.AccountFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/* Контроллер для перехода на страницу "Регистрация"*/

@Controller
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RegisterController {

    RegisterService registerService;

    //Эндпоинт выводит html-страницу register
    @GetMapping("signUp")
    public String openRegisterPage(Model model) {
        model.addAttribute("registerForm", new CreateRequestRegisterForm());
        return "/register";
    }

    //Эндпоинт обработки Объекта CreateRequestRegisterForm
    @PostMapping("/register")
    public String register(@Valid CreateRequestRegisterForm registerForm) {
        registerService.register(registerForm);
        return "redirect:/api/";
    }
}
