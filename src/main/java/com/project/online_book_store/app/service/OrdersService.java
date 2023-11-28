package com.project.online_book_store.app.service;

import com.project.online_book_store.app.domain.entity.BuyBook;

import java.util.List;
import java.util.Map;

/* Здесь хранится бизнес логика Сервиса Заказов*/

public interface OrdersService {
    void createOrder(Long cartId);

    Map<Long, List<BuyBook>> createMapListOrders();
}
