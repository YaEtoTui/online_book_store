package com.project.online_book_store;

import com.project.online_book_store.app.domain.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientNameGetRepository extends CrudRepository<Client, String> {
}
