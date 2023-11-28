package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Репозиторий Корзина, связующий сервиса и бд, где получаем необходимую сущность Корзина*/

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
