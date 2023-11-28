package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Репозиторий Аккаунт, связующий сервиса и бд, где получаем необходимую сущность Аккаунт*/

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByUsername(String username);
}
