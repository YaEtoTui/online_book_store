package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Репозиторий Заказ, связующий сервиса и бд, где получаем необходимую сущность Заказ*/

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
