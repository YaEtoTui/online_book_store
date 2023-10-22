package com.project.online_book_store.app.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buy_step")
public class BuyStep extends BaseDomainEntity {
//    Date dataStepStart;
//    Date dataStepEnd;

    @OneToOne()
    @JoinColumn(name = "buy_id")
    Buy buy;
    @ManyToOne()
    @JoinColumn(name = "step_id")
    Step step;
}