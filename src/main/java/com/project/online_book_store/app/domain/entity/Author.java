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
@Table(name = "author")
public class Author extends BaseDomainEntity {
    String nameAuthor;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    List<Book> book = new LinkedList<>();
}
