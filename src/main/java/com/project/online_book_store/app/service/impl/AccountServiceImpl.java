package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.context.AccountContext;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestNewAccount;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.service.AccountService;
import com.project.online_book_store.app.service.factory.AccountFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/* Сервис для работы с аккаунтом: где добавляем новый аккаунт, проверка на аутентификацию*/

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    AccountFactory accountFactory;

    //Добавляет новый Аккаунт с ролью User
    @Override
    public Account addNewUserAccount(CreateRequestNewAccount account) {
        AccountContext accountContextUser = accountFactory.createAccountContext(account);
        Account accountEntity = new Account(accountContextUser, "ROLE_USER");
        return accountRepository.save(accountEntity);
    }

    //Добавляет новый Аккаунт с ролью Admin
    @Override
    public Account addNewAdminAccount(CreateRequestNewAccount account) {
        AccountContext accountContextAdmin = accountFactory.createAccountContext(account);
        Account accountEntity = new Account(accountContextAdmin, "ROLE_ADMIN");
        return accountRepository.save(accountEntity);
    }

    //Проверяем, что пользователь аутентифицирован
    @Override
    public Boolean isAuthenticated() {

        if (getAccount() != null) {
            return false;
        } else {
            return true;
        }
    }

    //Получаем Аккаунт
    @Override
    public Account getAccount() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return accountRepository.findAccountByUsername(username);
    }
}
