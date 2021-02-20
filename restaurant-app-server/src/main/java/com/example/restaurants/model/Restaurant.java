package com.example.restaurants.model;

import javax.persistence.*;

import com.example.restaurants.model.audit.DateAudit;

@Entity
@Table(name = "restaurant")
public class Restaurant extends DateAudit {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String restaurantName;

    private String cityName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Column(name = "restaurant_name")
	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

    @Column(name = "city_name")
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
