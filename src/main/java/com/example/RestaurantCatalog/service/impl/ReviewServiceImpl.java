package com.example.RestaurantCatalog.service.impl;

import com.example.RestaurantCatalog.entity.Restaurant;
import com.example.RestaurantCatalog.entity.Review;
import com.example.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.example.RestaurantCatalog.repository.RestaurantRepository;
import com.example.RestaurantCatalog.repository.ReviewRepository;
import com.example.RestaurantCatalog.service.ReviewService;
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
    public List<Review> getReviewRestaurantById(Integer id) throws RestaurantNotFoundException {
        Optional<List<Review>> byId = reviewRepository.findAllById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        throw new RestaurantNotFoundException(id);
    }

    @Override
    public List<Review> getRatingRestaurantById(Integer id) throws RestaurantNotFoundException{
        Optional<List<Review>> byId = reviewRepository.findAllById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        throw new RestaurantNotFoundException(id);
    }

    @Override
    public void addReview(Integer restaurantId, Integer rating, String review) throws RestaurantNotFoundException {
        Optional<Restaurant> byId = restaurantRepository.findById(restaurantId);
        if (byId.isPresent()){
            Restaurant restaurant = byId.get();
            Review review1 = Review.builder()
                    .restaurantId(restaurant)
                    .rating(rating)
                    .review(review)
                    .build();
            reviewRepository.save(review1);
        }
        throw new RestaurantNotFoundException(restaurantId);
    }

    @Override
    public void refactorReviewById(Integer id, String review) throws RestaurantNotFoundException {
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
