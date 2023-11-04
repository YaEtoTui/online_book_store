package com.project.online_book_store.app.service.factory;

import com.project.online_book_store.app.common.exception.NotFoundAuthorException;
import com.project.online_book_store.app.common.exception.NotFoundBookException;
import com.project.online_book_store.app.common.exception.NotFoundGenreException;
import com.project.online_book_store.app.domain.entity.Author;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.Genre;
import com.project.online_book_store.app.domain.entity.context.BookContext;
import com.project.online_book_store.app.domain.entity.dto.CreateRequestBook;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.AuthorRepository;
import com.project.online_book_store.app.repository.BookRepository;
import com.project.online_book_store.app.repository.GenreRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AdminFactory {

    BookRepository bookRepository;
    BookFactory bookFactory;
    AuthorRepository authorRepository;
    GenreRepository genreRepository;

    @SneakyThrows
    public Path addImageInFileSystem(MultipartFile image) {
        Path path = Paths.get("src\\main\\resources\\images\\" + image.getOriginalFilename()).toAbsolutePath();
        File convertImage = new File(path.toString());

        try (FileOutputStream fileOutputStream = new FileOutputStream(convertImage)) {
            fileOutputStream.write(image.getBytes());
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("File has uploaded!");
        return path;
    }

    public BookResponse saveInDBPath(Long id, Path pathImage) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundBookException(
                                String.format("Not found id '%s' book", id)
                        )
                );

        Book bookEntity = new Book(book, pathImage);

        bookRepository.save(bookEntity);

        return bookFactory.createBookResponse(bookEntity);
    }

    public BookContext createBookContext(CreateRequestBook createRequestBook) {

        Author author = authorRepository.findById(createRequestBook.getAuthorId())
                .orElseThrow(() -> new NotFoundAuthorException(
                        String.format("Not found author with id: %d", createRequestBook.getAuthorId())
                )
        );

        Genre genre = genreRepository.findById(createRequestBook.getGenreId())
                .orElseThrow(() -> new NotFoundGenreException(
                                String.format("Not found genre with id: %d", createRequestBook.getGenreId())
                        )
                );

        return new BookContext(
                createRequestBook.getName(),
                createRequestBook.getPage(),
                createRequestBook.getDescription(),
                createRequestBook.getLanguage(),
                createRequestBook.getYearIssue(),
                createRequestBook.getPrice(),
                createRequestBook.getCount(),
                author,
                genre
        );
    }
}
