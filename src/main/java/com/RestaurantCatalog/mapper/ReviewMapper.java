package com.RestaurantCatalog.mapper;

import com.RestaurantCatalog.dto.out.ReviewOutDto;
import com.RestaurantCatalog.dto.in.ReviewInDto;
import com.RestaurantCatalog.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

//    @Mappings({
//            @Mapping(source = "rating", target = "rating"),
//            @Mapping(source = "review", target = "review")
//    })

    ReviewOutDto mapReviewToReviewOutDto(Review review);
    Review mapReviewInDtoToReview(ReviewInDto reviewInDto);
}
