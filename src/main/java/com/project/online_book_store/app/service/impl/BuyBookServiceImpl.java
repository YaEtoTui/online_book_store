package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.repository.BuyBookRepository;
import com.project.online_book_store.app.service.BuyBookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/* Сервис по получению купленных книг*/

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class BuyBookServiceImpl implements BuyBookService {

    BuyBookRepository buyBookRepository;

    //Получает полный список купленных книг
    @Override
    public List<BuyBook> getListBuyBooks() {
        return buyBookRepository.findAll();
    }
}
