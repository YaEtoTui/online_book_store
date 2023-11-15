package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.context.AccountContext;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestNewAccount;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.service.factory.AccountFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountController {

    AccountRepository accountRepository;
    AccountFactory accountFactory;

    @PostMapping("/new/account")
    public ResponseEntity<Account> addAccount(@RequestBody CreateRequestNewAccount account) {
        AccountContext accountContext = accountFactory.createAccountContext(account);
        Account accountEntity = new Account(accountContext);
        accountRepository.save(accountEntity);
        return ResponseEntity.ok()
                .body(accountEntity);
    }
}
