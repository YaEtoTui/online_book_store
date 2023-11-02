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
@Table(name = "client")
public class Client extends BaseDomainEntity {
    String name;
    String email;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<Buy> buyList = new LinkedList<>();
    @OneToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;
}
