package com.project.online_book_store.app.domain.entity.dto.request;

import lombok.Getter;
import lombok.Setter;

/* Запрос на создание формы регистрации */

@Getter
@Setter
public class CreateRequestRegisterForm {
    private String username;
    private String password;
    private String name;
    private String email;
}
