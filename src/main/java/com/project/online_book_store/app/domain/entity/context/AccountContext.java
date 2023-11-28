package com.project.online_book_store.app.domain.entity.context;

import lombok.Value;

/* Контекст Аккаунт нужен, чтобы передать данные из запроса на сервис */

@Value
public class AccountContext {
    String username;
    String password;
}
