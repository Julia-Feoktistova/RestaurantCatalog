package com.example.RestaurantCatalog.service;

import com.example.RestaurantCatalog.entity.Review;
import com.example.RestaurantCatalog.exeption.RestaurantNotFoundException;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewRestaurantById(Integer id) throws RestaurantNotFoundException;
    List<Review> getRatingRestaurantById(Integer id) throws RestaurantNotFoundException;
    void addReview(Integer RestaurantId, Integer rating, String review) throws RestaurantNotFoundException;
    void refactorReviewById(Integer RestaurantId, String review) throws RestaurantNotFoundException;
}
