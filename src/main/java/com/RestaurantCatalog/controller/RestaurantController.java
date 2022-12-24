package com.RestaurantCatalog.controller;

import com.RestaurantCatalog.dto.in.RestaurantInDto;
import com.RestaurantCatalog.dto.in.UpdateRestaurantInDto;
import com.RestaurantCatalog.exeption.FoundationDateIsExpiredException;
import com.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.RestaurantCatalog.dto.out.RestaurantOutDto;
import com.RestaurantCatalog.entity.Restaurant;
import com.RestaurantCatalog.mapper.RestaurantMapper;
import com.RestaurantCatalog.service.RestaurantService;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class RestaurantController {
    private final RestaurantService service;
    private final RestaurantMapper mapper;

    public RestaurantController(RestaurantService service, RestaurantMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("getAll")
    public List<Restaurant> getAllRestaurants() {
        return service.getAll();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantOutDto getRestaurantById(@PathVariable Long restaurantId) throws RestaurantNotFoundException {
        Restaurant restaurant = service.getRestaurant(restaurantId);
        return mapper.mapRestaurantToRestaurantOutDto(restaurant);
    }

    @GetMapping("desk/{name}")
    public RestaurantOutDto getRestaurantByName(@PathVariable String name) {
        Restaurant restaurant = service.findByName(name);
        return mapper.mapRestaurantToRestaurantOutDto(restaurant);
    }

    @PostMapping("/restaurant")
    public RestaurantOutDto addRestaurant(@Valid @RequestBody RestaurantInDto restaurantInDto) throws NumberParseException, FoundationDateIsExpiredException {
        Restaurant restaurant = service.createRestaurant(restaurantInDto);
        return mapper.mapRestaurantToRestaurantOutDto(restaurant);
    }

    @PostMapping("ref/restaurant/{id}")
    public void refactorRestaurantById(@PathVariable Long id, @Valid @RequestBody UpdateRestaurantInDto restaurant) throws RestaurantNotFoundException {
        service.refactorRestaurantById(id, restaurant);
    }
}
