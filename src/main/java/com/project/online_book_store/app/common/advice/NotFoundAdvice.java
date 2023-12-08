package com.project.online_book_store.app.common.advice;

import com.project.online_book_store.app.common.exception.NotFoundAuthorException;
import com.project.online_book_store.app.common.exception.NotFoundGenreException;
import com.project.online_book_store.app.common.exception.NotFoundBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* Обработчик ошибок, если не найден один из объектов в БД */

@RestControllerAdvice
public class NotFoundAdvice {

    //Ловит ошибки NotFoundAuthorException, NotFoundBookException и NotFoundGenreException и возвращает сообщение
    @ExceptionHandler({NotFoundAuthorException.class, NotFoundBookException.class, NotFoundGenreException.class})
    public ResponseEntity<String> notFound(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }
}
