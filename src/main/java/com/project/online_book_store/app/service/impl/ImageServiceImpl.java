package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.service.ImageService;
import com.project.online_book_store.app.service.factory.ImageFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/* Сервис по выводу изображений из БД*/

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class ImageServiceImpl implements ImageService {

    ImageFactory imageFactory;

    //Метод получает UrlResource для вывода изображения по id купленной книги
    @Override
    @SneakyThrows
    public UrlResource getImageBuyBook(Long buyBookId) {
        return new UrlResource(imageFactory.checkImagePathWithBuyBook(buyBookId).toUri());
    }

    //Метод получает UrlResource для вывода изображения по id книги
    @Override
    @SneakyThrows
    public UrlResource getImageBook(Long bookId) {
        return new UrlResource(imageFactory.checkImagePathWithBook(bookId).toUri());
    }
}
