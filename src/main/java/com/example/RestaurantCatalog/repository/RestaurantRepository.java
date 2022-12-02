package com.example.RestaurantCatalog.repository;

import com.example.RestaurantCatalog.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
