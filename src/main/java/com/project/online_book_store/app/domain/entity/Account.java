package com.project.online_book_store.app.domain.entity;

import com.project.online_book_store.app.domain.entity.context.AccountContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* Сущность Аккаунт используется для передачи информации из БД на сервис и наоборот */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account extends BaseDomainEntity{

    String username;
    String password;
    String role;
    Boolean enabled;
    @OneToOne(mappedBy = "account", fetch = FetchType.LAZY)
    Client client;

    public Account(AccountContext account, String roleStatus) {
        username = account.getUsername();
        password = account.getPassword();
        role = roleStatus;
        enabled = true;
    }
}
