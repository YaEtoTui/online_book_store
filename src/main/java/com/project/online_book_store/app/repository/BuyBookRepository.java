package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.BuyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Репозиторий "Купленная книга", связующий сервиса и бд, где получаем необходимую сущность "Купленная книга"*/

@Repository
public interface BuyBookRepository extends JpaRepository<BuyBook, Long> {

    List<BuyBook> findAllByOrderId(Long id);

    List<BuyBook> findBuyBooksByClient_Id(Long buyId);

}
