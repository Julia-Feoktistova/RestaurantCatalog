package com.RestaurantCatalog.service;


import com.RestaurantCatalog.dto.in.RestaurantInDto;
import com.RestaurantCatalog.dto.in.UpdateRestaurantInDto;
import com.RestaurantCatalog.exeption.FoundationDateIsExpiredException;
import com.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.RestaurantCatalog.entity.Restaurant;
import com.google.i18n.phonenumbers.NumberParseException;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAll();
    Restaurant findByName(String name);
    Restaurant getRestaurant(Long restaurantId) throws RestaurantNotFoundException;
    Restaurant getRestaurantById(Long restaurantId) throws RestaurantNotFoundException;
    Restaurant addRestaurant(RestaurantInDto restaurantInDto) throws FoundationDateIsExpiredException, NumberParseException;
    LocalDate getFoundationDate(Long restaurantId) throws RestaurantNotFoundException;
    void refactorRestaurantById(Long restaurantId, UpdateRestaurantInDto restaurant) throws RestaurantNotFoundException;
    String getRestaurantNameById(Long restaurantId) throws RestaurantNotFoundException;
    Long createRestaurantByName(String name);
    Restaurant createRestaurant(RestaurantInDto restaurantInDto) throws NumberParseException, FoundationDateIsExpiredException;
}
