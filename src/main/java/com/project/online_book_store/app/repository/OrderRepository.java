package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByBuy_Client_Id(Long clientId);
}
