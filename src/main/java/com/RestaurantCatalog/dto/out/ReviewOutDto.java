package com.RestaurantCatalog.dto.out;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ReviewOutDto {
    private Long restaurantId;
    private Integer rating;
    private String review;
}
