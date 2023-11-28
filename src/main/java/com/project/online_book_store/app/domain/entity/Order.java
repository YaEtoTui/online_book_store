package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/* Сущность Заказ используется для передачи информации из репозитория на сервис и наоборот */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order extends BaseDomainEntity{
    @ManyToOne
    @JoinColumn(name = "buy_id")
    Buy buy;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    List<BuyBook> buyBookList = new LinkedList<>();

}
