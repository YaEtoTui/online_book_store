package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyBookRepository extends JpaRepository<BuyBook, Long> {
    List<BuyBook> findBuyBooksByOrderBuyClient_Id(Long clientId);

    List<BuyBook> findAllByOrderId(Long id);

    List<BuyBook> findBuyBooksByClient_Id(Long buyId);

    List<BuyBook> findBuyBooksByOrderBuy_Id(Long id);
}
