package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/* Сущность Жанр используется для передачи информации из БД на сервис и наоборот */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genre")
public class Genre extends BaseDomainEntity {
    String name;
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    List<Book> book = new LinkedList<>();
}
