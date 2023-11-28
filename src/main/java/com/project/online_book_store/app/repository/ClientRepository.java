package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Репозиторий Клиент, связующий сервиса и бд, где получаем необходимую сущность Клиент*/

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
