package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/* Сущность "Книга в Корзине" используется для передачи информации из репозитория на сервис и наоборот */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_in_cart")
public class BookInCart extends BaseDomainEntity {

    @JoinColumn(name = "book_id")
    @ManyToOne()
    Book book;

    @JoinColumn(name = "cart_id")
    @ManyToOne()
    Cart cart;
}
