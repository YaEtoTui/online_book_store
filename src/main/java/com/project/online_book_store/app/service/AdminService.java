package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.dto.CreateRequestBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AdminService {
    BookResponse uploadImage(Long imageId, MultipartFile image);

    BookResponse addNewBook(CreateRequestBook createRequestBook);
}
