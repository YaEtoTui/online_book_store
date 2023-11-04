package com.project.online_book_store.app.repository;

import com.project.online_book_store.app.domain.entity.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

}
