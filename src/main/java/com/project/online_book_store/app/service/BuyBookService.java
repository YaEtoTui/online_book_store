package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.Author;
import com.project.online_book_store.app.domain.entity.Book;
import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.domain.entity.Client;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BuyBookRepository;
import com.project.online_book_store.app.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class BuyBookService {

    BuyBookRepository buyBookRepository;
    ClientRepository clientRepository;

    public List<BookResponse> showBooks() {
        Client client = clientRepository.findClientByName("Egor");
        List<BuyBook> bookList = buyBookRepository.findAllByBuy_Client(client);

        return bookList.stream()
                .map(this::createBookResponse)
                .collect(Collectors.toList());
    }

    public BookResponse createBookResponse(BuyBook book) {
        return new BookResponse(
                book.getBook().getId(),
                book.getBook().getName(),
                book.getBook().getPage(),
                book.getBook().getPrice(),
                book.getBook().getCount(),
                createAuthorInfo(book.getBook().getAuthor())
        );
    }

    private BookResponse.AuthorInfo createAuthorInfo(Author author) {
        return new BookResponse.AuthorInfo(
                author.getNameAuthor()
        );
    }
}
