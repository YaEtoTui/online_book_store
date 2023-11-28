package com.project.online_book_store.app.common.exception;

/* Возникает ошибка, если в БД не найден автор*/

public class NotFoundAuthorException extends RuntimeException {

    public NotFoundAuthorException(String msg) {
        super(msg);
    }
}
