package com.project.online_book_store.app.domain.entity.dto.request;

import lombok.Value;

@Value
public class CreateRequestNewAccount {
    String username;
    String password;
}
