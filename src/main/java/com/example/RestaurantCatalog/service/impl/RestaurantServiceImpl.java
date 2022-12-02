package com.example.RestaurantCatalog.service.impl;

import com.example.RestaurantCatalog.dto.in.RestaurantInDto;
import com.example.RestaurantCatalog.entity.Restaurant;
import com.example.RestaurantCatalog.exeption.FoundationDateIsExpiredException;
import com.example.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.example.RestaurantCatalog.mapper.RestaurantMapper;
import com.example.RestaurantCatalog.repository.RestaurantRepository;
import com.example.RestaurantCatalog.service.RestaurantService;
import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getDescriptionRestaurantById(Integer id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public Restaurant addRestaurant(RestaurantInDto restaurantInDto) throws FoundationDateIsExpiredException, NumberParseException {
        if (restaurantInDto.getFoundationDate() == null|| LocalDate.now().isBefore(restaurantInDto.getFoundationDate())){
            throw new FoundationDateIsExpiredException(restaurantInDto.getName(), restaurantInDto.getFoundationDate());
        }
        Restaurant restaurant = restaurantMapper.mapRestaurantInDtoToRestaurant(restaurantInDto);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public LocalDate getFoundationDate(Integer id) {
        Restaurant restaurantById = getDescriptionRestaurantById(id);
        return restaurantById.getFoundationDate();
    }

    @Override
    public void refactorRestaurantById(Integer id, String description) throws RestaurantNotFoundException {
        Optional<Restaurant> byId = restaurantRepository.findById(id);
        if (byId.isPresent()){
            Restaurant restaurant = byId.get();
            restaurant.setDescription(description);
            restaurantRepository.save(restaurant);
        } else {
            throw new RestaurantNotFoundException(id);
        }
    }
}
