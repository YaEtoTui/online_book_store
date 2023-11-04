package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.domain.entity.Client;
import com.project.online_book_store.app.domain.entity.dto.response.BookResponse;
import com.project.online_book_store.app.repository.BuyBookRepository;
import com.project.online_book_store.app.repository.ClientRepository;
import com.project.online_book_store.app.service.BuyBookService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class BuyBookServiceImpl implements BuyBookService {

    BuyBookRepository buyBookRepository;
    ClientRepository clientRepository;

    @Override
    public List<BookResponse> showBooks() {
        Client client = clientRepository.findClientByName("Egor");
        List<BuyBook> bookList = buyBookRepository.findAllByBuy_Client(client);
//        return buyBookFactory.createBookListResponse(bookList);
        return null;
    }

    @Override
    public List<BuyBook> getListBuyBooks() {
        return buyBookRepository.findAll();
    }
}
