package com.project.online_book_store.web.controller;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.context.AccountContext;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestNewAccount;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.service.AccountService;
import com.project.online_book_store.app.service.factory.AccountFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Контроллер для создания новых аккаунтов(Было сделано, чтобы добавить хотя бы 1 аккаунт, просто так в liquibase нельзя добавить
*   из-за кодирования пароля
* */


@RestController
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountController {

    AccountService accountService;

    @PostMapping("/new/account")
    public ResponseEntity<Account> addNewUserAccount(@RequestBody CreateRequestNewAccount account) {
        return ResponseEntity.ok()
                .body(accountService.addNewUserAccount(account));
    }

    @PostMapping("/new/admin/account")
    public ResponseEntity<Account> addNewAdminAccount(@RequestBody CreateRequestNewAccount account) {
        return ResponseEntity.ok()
                .body(accountService.addNewAdminAccount(account));
    }
}
