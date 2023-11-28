package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/* Сущность Корзина используется для передачи информации из БД на сервис и наоборот */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart extends BaseDomainEntity {
    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    List<BookInCart> bookInCartList = new LinkedList<>();
    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    Client client;
}
