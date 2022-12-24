package com.RestaurantCatalog.service.impl;

import com.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.RestaurantCatalog.service.ReviewService;
import com.RestaurantCatalog.entity.Restaurant;
import com.RestaurantCatalog.entity.Review;
import com.RestaurantCatalog.repository.RestaurantRepository;
import com.RestaurantCatalog.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Review> getReviewRestaurantById(Long id) throws RestaurantNotFoundException {
        List<Review> byId = reviewRepository.getReviewById(id);
        if (!(byId.isEmpty())){
            return byId;
        }
        throw new RestaurantNotFoundException(id);
    }
//
//    @Override
//    public Review getReviewRestaurantByName(String restaurantName) {
//        Review reviewByRestaurantName = reviewRepository.getReviewByName(restaurantName);
//        return reviewByRestaurantName;
//    }


    @Override
    public void addReview(Long restaurantId, Integer rating, String review) throws RestaurantNotFoundException {
        Optional<Restaurant> byId = restaurantRepository.findById(restaurantId);
        if (byId.isPresent()){
            Restaurant restaurant = byId.get();
            Review review1 = Review.builder()
                    .restaurant(restaurant)
                    .rating(rating)
                    .review(review)
                    .build();
            reviewRepository.save(review1);
        }
        throw new RestaurantNotFoundException(restaurantId);
    }

    @Override
    public void refactorReviewById(Long id, String review) throws RestaurantNotFoundException {
        Optional<Review> byId = reviewRepository.findById(id);
        if (byId.isPresent()){
            Review review1 = byId.get();
            review1.setReview(review);
            reviewRepository.save(review1);
        } else {
            throw new RestaurantNotFoundException(id);
        }
    }
}
