package com.example.restaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurants.payload.PagedResponse;
import com.example.restaurants.security.CurrentUser;
import com.example.restaurants.security.UserPrincipal;
import com.example.restaurants.service.RestaurantService;
import com.example.restaurants.util.AppConstants;
import com.example.restaurants.model.Restaurant;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping
	public PagedResponse<Restaurant> getRestaurants(@CurrentUser UserPrincipal currentUser,
			@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
			@RequestParam(value = "cityName") String cityName) {
		return restaurantService.getRestaurantsByCityName(cityName, page, size);
	}

}
