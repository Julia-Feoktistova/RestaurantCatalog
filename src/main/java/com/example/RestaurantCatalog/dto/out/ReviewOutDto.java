package com.example.RestaurantCatalog.dto.out;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class ReviewOutDto {
    private Integer id;
    private Integer RestaurantId;
    private Integer rating;
    private String review;

}
