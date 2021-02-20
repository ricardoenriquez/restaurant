package com.example.restaurants.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.restaurants.payload.PagedResponse;
import com.example.restaurants.repository.RestaurantRepository;
import com.example.restaurants.util.AppConstants;
import com.example.restaurants.exception.BadRequestException;
import com.example.restaurants.model.Restaurant;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public PagedResponse<Restaurant> getRestaurantsByCityName(String cityName, int page, int size) {
        validatePageNumberAndSize(page, size);

        // Retrieve Restaurants
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Restaurant> restaurants = restaurantRepository.findByCityName(cityName,pageable);

        if(restaurants.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), restaurants.getNumber(),
                    restaurants.getSize(), restaurants.getTotalElements(), restaurants.getTotalPages(), restaurants.isLast());
        }

        return new PagedResponse<>(restaurants.getContent(), restaurants.getNumber(),
                restaurants.getSize(), restaurants.getTotalElements(), restaurants.getTotalPages(), restaurants.isLast());
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
