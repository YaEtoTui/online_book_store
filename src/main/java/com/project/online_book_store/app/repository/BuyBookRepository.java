package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Buy;
import com.project.online_book_store.app.domain.entity.BuyBook;
import com.project.online_book_store.app.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyBookRepository extends JpaRepository<BuyBook, Long> {

    List<BuyBook> findAllByBuy_Client(Client client);
    List<BuyBook> findAllByBuy_Client_Id(Long clientId);

    List<BuyBook> findAllByBuy_Id(Long buyId);

    List<BuyBook> findAllByNumber(Integer number);

}
