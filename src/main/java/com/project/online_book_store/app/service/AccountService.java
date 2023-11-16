package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestNewAccount;

/* Здесь хранится бизнес логика Сервиса аккаунтов*/

public interface AccountService {

    Account addNewUserAccount(CreateRequestNewAccount account);
    Account addNewAdminAccount(CreateRequestNewAccount account);

    Boolean isAuthenticated();

    Account getAccount();
}
