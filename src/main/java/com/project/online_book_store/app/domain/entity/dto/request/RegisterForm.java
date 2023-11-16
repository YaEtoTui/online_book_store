package com.project.online_book_store.app.domain.entity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
    private String username;
    private String password;
    private String name;
    private String email;
}
