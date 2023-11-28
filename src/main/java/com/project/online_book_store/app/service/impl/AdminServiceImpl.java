package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.context.BookContext;
import com.project.online_book_store.app.domain.entity.dto.request.CreateRequestBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.service.AdminService;
import com.project.online_book_store.app.service.factory.AdminFactory;
import com.project.online_book_store.app.service.factory.BookFactory;
import javax.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    AdminFactory adminFactory;
    BookRepository bookRepository;
    BookFactory bookFactory;

    @Override
    public BookResponse uploadImage(Long imageId, MultipartFile image) {
        Path pathImage = adminFactory.addImageInFileSystem(image);
        return adminFactory.saveInDBPath(imageId, pathImage);
    }

    @Override
    public BookResponse addNewBook(CreateRequestBook createRequestBook) {
        BookContext bookContext = adminFactory.createBookContext(createRequestBook);
        Book book = new Book(bookContext);
        Book bookEntity = bookRepository.save(book);
        return bookFactory.createBookResponse(bookEntity);
    }

    @Override
    public BookResponse deleteBook(Long bookId) {
        Book book = bookRepository.getReferenceById(bookId);
        bookRepository.delete(book);
        return bookFactory.createBookResponse(book);
    }
}
