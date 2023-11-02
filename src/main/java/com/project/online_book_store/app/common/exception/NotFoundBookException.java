package com.project.online_book_store.app.common.exception;

public class NotFoundBookException extends RuntimeException {

    public NotFoundBookException(String msg) {
        super(msg);
    }
}
