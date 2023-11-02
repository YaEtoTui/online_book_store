package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.Buy;
import com.project.online_book_store.app.domain.entity.Client;
import com.project.online_book_store.app.repository.ClientRepository;
import com.project.online_book_store.app.service.BuyService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class BuyServiceImpl implements BuyService {

    ClientRepository clientRepository;

    @Override
    public Buy searchBuyByClient() {
        Client client = clientRepository.getReferenceById(5L);
//        return client.
        return null;
    }
}
