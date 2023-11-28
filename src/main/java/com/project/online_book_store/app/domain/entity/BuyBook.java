package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* Сущность "Купленная книга" используется для передачи информации из репозитория на сервис и наоборот */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buy_book")
public class BuyBook extends BaseDomainEntity {
    String name;
    String author;
    String pathImage;

    @JoinColumn(name = "order_id")
    @ManyToOne
    Order order;

    @JoinColumn(name = "client_id")
    @ManyToOne
    Client client;
}
