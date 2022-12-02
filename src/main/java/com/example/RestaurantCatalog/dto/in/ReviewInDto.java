package com.example.RestaurantCatalog.dto.in;


import com.example.RestaurantCatalog.entity.Restaurant;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@EqualsAndHashCode
public class ReviewInDto {

    @NotNull
    private Restaurant restaurant;
    private Integer rating;
    private String review;
}
