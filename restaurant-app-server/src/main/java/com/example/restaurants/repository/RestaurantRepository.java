package com.example.restaurants.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restaurants.model.Restaurant;

/**
 * Created by ricardoeq90@gmail.com on 20/02/2021.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	Page<Restaurant> findByCityName(String cityName, Pageable pageable);

}
