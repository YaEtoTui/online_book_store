package com.project.online_book_store.app.domain.entity;

import com.project.online_book_store.app.domain.entity.dto.request.RegisterForm;
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
@Table(name = "client")
public class Client extends BaseDomainEntity {
    String name;
    String email;
    @OneToOne
    @JoinColumn(name = "buy_id")
    Buy buy;
    @OneToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;
}
