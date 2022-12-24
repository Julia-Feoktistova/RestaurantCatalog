package com.RestaurantCatalog.service;

import com.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.RestaurantCatalog.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewRestaurantById(Long id) throws RestaurantNotFoundException;
    //Review getReviewRestaurantByName(String restaurantName);
    void addReview(Long RestaurantId, Integer rating, String review) throws RestaurantNotFoundException;
    void refactorReviewById(Long RestaurantId, String review) throws RestaurantNotFoundException;

}
