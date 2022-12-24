package com.RestaurantCatalog.exeption;

import java.time.LocalDate;

public class FoundationDateIsExpiredException extends Throwable{
    private final String restaurantName;
    private final LocalDate foundationDate;


    public FoundationDateIsExpiredException(String restaurantName, LocalDate foundationDate) {
        this.restaurantName = restaurantName;
        this.foundationDate = foundationDate;
    }

    @Override
    public String toString() {
        return "restaurant with name \"" + restaurantName + "\"" +
                "has foundation date " + foundationDate;
    }
}
