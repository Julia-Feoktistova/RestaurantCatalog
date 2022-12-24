package com.RestaurantCatalog.repository;

import com.RestaurantCatalog.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
     Restaurant findByName(String name);

}
