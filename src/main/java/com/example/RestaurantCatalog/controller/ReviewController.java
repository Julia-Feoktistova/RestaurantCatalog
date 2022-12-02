package com.example.RestaurantCatalog.controller;

import com.example.RestaurantCatalog.dto.out.ReviewOutDto;
import com.example.RestaurantCatalog.entity.Review;
import com.example.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.example.RestaurantCatalog.mapper.ReviewMapper;
import com.example.RestaurantCatalog.service.impl.ReviewServiceImpl;
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

    @GetMapping("rev/{id}")
    public List<ReviewOutDto> getReviewRestaurantById(@PathVariable("id") Integer id) throws RestaurantNotFoundException {
        List<Review> reviews = service.getReviewRestaurantById(id);
        List<ReviewOutDto> reviewOutDtoList = new ArrayList<>();
        for (Review r: reviews) {
            reviewOutDtoList.add(mapper.mapReviewToReviewOutDto(r));
            }
        return reviewOutDtoList;
    }

    @GetMapping("rat/{id}")
    public List<ReviewOutDto> getRatingRestaurantById(@PathVariable("id") Integer id) throws RestaurantNotFoundException {
        List<Review> reviews = service.getRatingRestaurantById(id);
        List<ReviewOutDto> reviewOutDtoList = new ArrayList<>();
        for (Review r: reviews) {
            reviewOutDtoList.add(mapper.mapReviewToReviewOutDto(r));
        }
        return reviewOutDtoList;
    }

    @PostMapping("add/rev")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@RequestParam (value = "RestaurantId") Integer RestaurantId,
            @RequestParam(value = "rating") Integer rating,
            @RequestParam(value = "review") String review) throws RestaurantNotFoundException {
        service.addReview(RestaurantId, rating, review);
    }

    @PostMapping("ref/rev/{RestaurantId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void refactorReviewById(@RequestParam(value = "review") String review,
                                   @PathVariable Integer RestaurantId) throws RestaurantNotFoundException {
        service.refactorReviewById(RestaurantId, review);
    }
}
