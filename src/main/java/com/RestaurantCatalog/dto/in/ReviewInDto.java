package com.RestaurantCatalog.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Builder
@Getter
public class ReviewInDto {

    @NotNull
    private final Long restaurantId;
    private final Integer rating;
    private final String review;
}
