package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import org.springframework.web.multipart.MultipartFile;

/* Здесь хранится бизнес логика Сервиса Админ*/

public interface AdminService {
    BookResponse uploadImage(Long imageId, MultipartFile image);

    BookResponse addNewBook(CreateRequestBook createRequestBook);

    BookResponse deleteBook(Long bookId);
}
