package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Репозиторий Жанр, связующий сервиса и бд, где получаем необходимую сущность Жанр*/

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
