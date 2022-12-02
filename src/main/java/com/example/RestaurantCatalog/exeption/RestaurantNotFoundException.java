package com.example.RestaurantCatalog.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantNotFoundException extends Exception{
    private final Integer restaurantId;

    public RestaurantNotFoundException(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }
}
