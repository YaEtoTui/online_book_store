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

    AccountRepository accountRepository;
    CartRepository cartRepository;
    BuyRepository buyRepository;
    ClientRepository clientRepository;
    AccountFactory accountFactory;

    @GetMapping("signUp")
    public String openRegisterPage(Model model) {
        model.addAttribute("registerForm", new CreateRequestRegisterForm());
        return "/register";
    }

    @PostMapping("/register")
    public String register(@Valid CreateRequestRegisterForm registerForm) {
        AccountContext accountContext = accountFactory.createAccountContextRegisterForm(registerForm);
        Account account = new Account(accountContext, "ROLE_USER");
        Account accountEntity = accountRepository.save(account);

        Cart cart = new Cart();
        Cart cartEntity = cartRepository.save(cart);


        Buy buy = new Buy();
        Buy buyEntity = buyRepository.save(buy);

        if(cartEntity != null && accountEntity != null && buyEntity != null) {
            Client client = new Client(
                    registerForm.getName(),
                    registerForm.getEmail(),
                    buyEntity,
                    cartEntity,
                    accountEntity
                    );
            Client clientEntity = clientRepository.save(client);
            if (clientEntity != null) {
                System.out.println("Клиент создался");
            }
        }

        return "redirect:/api/";
    }
}
