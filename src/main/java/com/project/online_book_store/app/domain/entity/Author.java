package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

/* Сущность Автор используется для передачи информации из репозитория на сервис и наоборот */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author extends BaseDomainEntity {
    String nameAuthor;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    List<Book> book = new LinkedList<>();
}
