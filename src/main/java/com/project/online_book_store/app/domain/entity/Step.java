package com.project.online_book_store.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "step")
public class Step extends BaseDomainEntity {
    String nameStep;
    @OneToMany(mappedBy = "step", fetch = FetchType.LAZY)
    List<BuyStep> buyStep = new LinkedList<>();
}
