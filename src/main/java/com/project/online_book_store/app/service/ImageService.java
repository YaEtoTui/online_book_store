package com.project.online_book_store.app.service;

import org.springframework.core.io.UrlResource;

public interface ImageService {

    UrlResource getImageBuyBook(Long buyBookId);
    UrlResource getImageBook(Long bookId);
}
