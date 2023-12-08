package com.project.online_book_store.app.service.impl;

import com.project.online_book_store.app.domain.entity.Account;
import com.project.online_book_store.app.domain.entity.Buy;
import com.project.online_book_store.app.domain.entity.Client;
import com.project.online_book_store.app.repository.AccountRepository;
import com.project.online_book_store.app.repository.ClientRepository;
import com.project.online_book_store.app.service.BuyService;
import javax.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/* Сервис по нахождению покупок совершенных*/

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class BuyServiceImpl implements BuyService {

    ClientRepository clientRepository;
    AccountRepository accountRepository;

    //Ищет Покупку по клиенту
    @Override
    public Buy searchBuyByClient() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountRepository.findAccountByUsername(username);
        Client client = clientRepository.getReferenceById(account.getClient().getId());
        return client.getBuy();
    }
}
