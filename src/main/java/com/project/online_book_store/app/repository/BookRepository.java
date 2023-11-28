package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Репозиторий Книга, связующий сервиса и бд, где получаем необходимую сущность Книга*/

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
