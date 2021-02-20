package com.example.restaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurants.payload.PagedResponse;
import com.example.restaurants.service.TransactionService;
import com.example.restaurants.util.AppConstants;
import com.example.restaurants.model.Transaction;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping
	public PagedResponse<Transaction> getRestaurants(
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		return transactionService.getTransactions(page, size);
	}

}
