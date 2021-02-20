package com.example.restaurants.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.restaurants.payload.PagedResponse;
import com.example.restaurants.repository.TransactionRepository;
import com.example.restaurants.util.AppConstants;
import com.example.restaurants.exception.BadRequestException;
import com.example.restaurants.model.Transaction;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public PagedResponse<Transaction> getTransactions(int page, int size) {
        validatePageNumberAndSize(page, size);

        // Retrieve Transactions
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Transaction> transactions = transactionRepository.findAll(pageable);

        if(transactions.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), transactions.getNumber(),
                    transactions.getSize(), transactions.getTotalElements(), transactions.getTotalPages(), transactions.isLast());
        }

        return new PagedResponse<>(transactions.getContent(), transactions.getNumber(),
                transactions.getSize(), transactions.getTotalElements(), transactions.getTotalPages(), transactions.isLast());
    }

    private void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }

}
