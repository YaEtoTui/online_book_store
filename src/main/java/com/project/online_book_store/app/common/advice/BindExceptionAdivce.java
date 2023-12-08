package com.project.online_book_store.app.common.advice;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* Обработчик ошибок, если ошибка 400 при валидации */

@ControllerAdvice
public class BindExceptionAdivce {

    // Ловит ошибку BindException и возвращает страницу 400
    @ExceptionHandler({BindException.class})
    public String bindExc(Exception exception, Model model) {
        model.addAttribute("msg", exception.getMessage());
        return "error_400";
    }
}
