package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Репозиторий Покупка, связующий сервиса и бд, где получаем необходимую сущность Покупка*/

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

}
