package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Репозиторий Автор, связующий сервиса и бд, где получаем необходимую сущность автор*/

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
