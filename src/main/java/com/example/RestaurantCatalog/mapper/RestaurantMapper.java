package com.example.RestaurantCatalog.mapper;

import com.example.RestaurantCatalog.dto.in.RestaurantInDto;
import com.example.RestaurantCatalog.dto.out.RestaurantOutDto;
import com.example.RestaurantCatalog.entity.Restaurant;
import com.google.i18n.phonenumbers.NumberParseException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RestaurantMapper {

    public abstract RestaurantOutDto mapRestaurantToRestaurantOutDto(Restaurant restaurant);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "telephoneNumber",
            expression = "java(com.example.RestaurantCatalog.util.Util.reformatRuTelephone(restaurantInDto.getTelephoneNumber()))"
    )

    public abstract Restaurant mapRestaurantInDtoToRestaurant(RestaurantInDto restaurantInDto) throws NumberParseException;
}
