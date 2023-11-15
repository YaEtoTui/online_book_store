package com.project.online_book_store.app.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public class BaseDomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;
}
