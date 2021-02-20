package com.example.restaurants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurants.model.Transaction;

/**
 * Created by ricardoeq90@gmail.com on 20/02/2021.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	Page<Transaction> findAll(Pageable pageable);

}
