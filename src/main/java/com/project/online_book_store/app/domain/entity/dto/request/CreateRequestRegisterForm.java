package com.project.online_book_store.app.domain.entity.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/* Запрос на создание формы регистрации */

@Getter
@Setter
public class CreateRequestRegisterForm {
    @NotEmpty
    private String username;
    @NotEmpty
    @Size(min = 6, max = 10)
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
}
