package com.RestaurantCatalog.mapper;

import com.RestaurantCatalog.dto.in.RestaurantInDto;
import com.RestaurantCatalog.dto.out.RestaurantOutDto;
import com.RestaurantCatalog.entity.Restaurant;
import com.google.i18n.phonenumbers.NumberParseException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public abstract class RestaurantMapper {

    public abstract RestaurantOutDto mapRestaurantToRestaurantOutDto(Restaurant restaurant);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "telephoneNumber",
            expression = "java(com.RestaurantCatalog.util.Util.reformatRuTelephone(restaurantInDto.getTelephoneNumber()))"
    )

    public abstract Restaurant mapRestaurantInDtoToRestaurant(RestaurantInDto restaurantInDto) throws NumberParseException;


    public abstract RestaurantOutDto mapRestaurantToRestaurantOutDtoDate(LocalDate date);
}
