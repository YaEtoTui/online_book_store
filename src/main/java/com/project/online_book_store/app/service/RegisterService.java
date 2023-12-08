package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestRegisterForm;

/* Здесь хранится бизнес логика Сервиса Регистрации*/

public interface RegisterService {
    void register(CreateRequestRegisterForm form);
}
