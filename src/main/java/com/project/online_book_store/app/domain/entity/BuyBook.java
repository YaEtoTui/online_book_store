package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buy_book")
public class BuyBook extends BaseDomainEntity {
    Integer number;
    String name;
    String pathImage;
    @ManyToOne()
    @JoinColumn(name = "buy_id")
    Buy buy;
}
