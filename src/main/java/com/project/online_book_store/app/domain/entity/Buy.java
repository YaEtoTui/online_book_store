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
@Table(name = "buy")
public class Buy extends BaseDomainEntity {
    @OneToOne()
    @JoinColumn(name = "client_id")
    Client client;
    @OneToOne(mappedBy = "buy", fetch = FetchType.LAZY)
    BuyBook buyBook;
    @OneToOne(mappedBy = "buy" , fetch = FetchType.LAZY)
    BuyStep buyStep;
}

