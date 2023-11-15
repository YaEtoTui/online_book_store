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

    public Account(AccountContext account) {
        username = account.getUsername();
        password = account.getPassword();
        role = "ROLE_USER";
        enabled = true;
    }
}
