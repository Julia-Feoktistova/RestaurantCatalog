package com.RestaurantCatalog.controller;

import com.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.RestaurantCatalog.service.impl.ReviewServiceImpl;
import com.RestaurantCatalog.dto.out.ReviewOutDto;
import com.RestaurantCatalog.entity.Review;
import com.RestaurantCatalog.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ReviewController {
    private final ReviewServiceImpl service;

    @Autowired
    private ReviewMapper mapper;

    public ReviewController(ReviewServiceImpl service) {
        this.service = service;
    }

    @GetMapping("rev/{restaurantId}")
    public List<ReviewOutDto> getReviewRestaurantById(@PathVariable("restaurantId") Long restaurantId) throws RestaurantNotFoundException {
        List<Review> reviews = service.getReviewRestaurantById(restaurantId);
        List<ReviewOutDto> reviewOutDtoList = new ArrayList<>();
        for (Review r: reviews) {
            reviewOutDtoList.add(mapper.mapReviewToReviewOutDto(r));
            }
        return reviewOutDtoList;
    }

    @PostMapping("add/rev")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@RequestParam (value = "restaurant_id") Long RestaurantId,
            @RequestParam(value = "rating") Integer rating,
            @RequestParam(value = "review") String review) throws RestaurantNotFoundException {
        service.addReview(RestaurantId, rating, review);
    }
}
