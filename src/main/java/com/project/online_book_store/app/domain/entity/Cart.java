package com.project.online_book_store.app.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

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
