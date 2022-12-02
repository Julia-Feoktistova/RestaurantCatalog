package com.example.RestaurantCatalog.service;


import com.example.RestaurantCatalog.dto.in.RestaurantInDto;
import com.example.RestaurantCatalog.entity.Restaurant;
import com.example.RestaurantCatalog.exeption.FoundationDateIsExpiredException;
import com.example.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.google.i18n.phonenumbers.NumberParseException;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();
    Restaurant getDescriptionRestaurantById(Integer id);
    Restaurant addRestaurant(RestaurantInDto restaurantInDto/*String name, String address, String description,LocalDate foundationDate*/) throws FoundationDateIsExpiredException, NumberParseException;
    LocalDate getFoundationDate(Integer id) throws RestaurantNotFoundException;
    void refactorRestaurantById(Integer id, String description) throws RestaurantNotFoundException;

}
