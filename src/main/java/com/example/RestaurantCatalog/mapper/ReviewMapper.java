package com.example.RestaurantCatalog.mapper;

import com.example.RestaurantCatalog.dto.in.ReviewInDto;
import com.example.RestaurantCatalog.dto.out.ReviewOutDto;
import com.example.RestaurantCatalog.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewOutDto mapReviewToReviewOutDto(Review review);
    //todo Review mapReviewInDtoToReview(ReviewInDto reviewInDto);
}
