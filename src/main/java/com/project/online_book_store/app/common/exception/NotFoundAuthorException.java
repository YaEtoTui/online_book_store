package com.project.online_book_store.app.common.exception;

public class NotFoundAuthorException extends RuntimeException {

    public NotFoundAuthorException(String msg) {
        super(msg);
    }
}
