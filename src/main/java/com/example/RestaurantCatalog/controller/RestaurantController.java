package com.example.RestaurantCatalog.controller;

import com.example.RestaurantCatalog.dto.in.RestaurantInDto;
import com.example.RestaurantCatalog.dto.out.RestaurantOutDto;
import com.example.RestaurantCatalog.entity.Restaurant;
import com.example.RestaurantCatalog.exeption.FoundationDateIsExpiredException;
import com.example.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.example.RestaurantCatalog.mapper.RestaurantMapper;
import com.example.RestaurantCatalog.service.RestaurantService;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public abstract class RestaurantController {
    private final RestaurantService service;
    private Restaurant restaurantDesk;

    @Autowired
    private RestaurantMapper mapper;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping("getAll")
    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) service.getAll();
    }

    @GetMapping("desk/{id}")
    public RestaurantOutDto getDescriptionRestaurantById(@PathVariable("id") Integer id) {
        restaurantDesk = service.getDescriptionRestaurantById(id);
        return mapper.mapRestaurantToRestaurantOutDto(restaurantDesk);
    }


    @PostMapping("add/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantOutDto addRestaurant(@RequestParam(value = "name") String name,
                                          @RequestParam(value = "address") String address,
                                          @RequestParam(value = "description") String description,
                                          @RequestParam(value = "foundation_date") @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate foundationDate)
            throws FoundationDateIsExpiredException, NumberParseException {
        RestaurantInDto restaurantInDto = RestaurantInDto.builder()
                .name(name)
                .address(address)
                .description(description)
                .foundationDate(foundationDate)
                .build();
        service.addRestaurant(restaurantInDto);
        Restaurant restaurant = mapper.mapRestaurantInDtoToRestaurant(restaurantInDto);
        return mapper.mapRestaurantToRestaurantOutDto(restaurant);
    }

    @PostMapping("ref/restaurant/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void refactorRestaurantById(@RequestParam (value = "description") String description,
                                       @PathVariable Integer id) throws RestaurantNotFoundException {
        service.refactorRestaurantById(id, description);

    }


}
