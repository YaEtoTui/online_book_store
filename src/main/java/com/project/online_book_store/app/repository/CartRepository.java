package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Cart;
import com.project.online_book_store.app.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findCartByClient(Client client);

    Cart findCartByClientId(Long clientID);
}
