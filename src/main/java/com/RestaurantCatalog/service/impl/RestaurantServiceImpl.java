package com.RestaurantCatalog.service.impl;

import com.RestaurantCatalog.dto.in.RestaurantInDto;
import com.RestaurantCatalog.dto.in.UpdateRestaurantInDto;
import com.RestaurantCatalog.exeption.FoundationDateIsExpiredException;
import com.RestaurantCatalog.exeption.RestaurantNotFoundException;
import com.RestaurantCatalog.entity.Restaurant;
import com.RestaurantCatalog.mapper.RestaurantMapper;
import com.RestaurantCatalog.repository.RestaurantRepository;
import com.RestaurantCatalog.service.RestaurantService;
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

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }


    @Override
    public Restaurant getRestaurant(Long restaurantId) throws RestaurantNotFoundException {
        return getRestaurantById(restaurantId);
    }


    public Restaurant getRestaurantById(Long id) throws RestaurantNotFoundException {
        Optional<Restaurant> byId = restaurantRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RestaurantNotFoundException(id);
        }
        return byId.get();
    }

    @Override
    public String getRestaurantNameById(Long restaurantId) throws RestaurantNotFoundException {
        return getRestaurantById(restaurantId).getName();
    }

    @Override
    public Restaurant findByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public Restaurant addRestaurant(RestaurantInDto restaurantInDto) throws FoundationDateIsExpiredException, NumberParseException {
        if (restaurantInDto.getFoundationDate() == null || LocalDate.now().isBefore(restaurantInDto.getFoundationDate())) {
            throw new FoundationDateIsExpiredException(restaurantInDto.getName(), restaurantInDto.getFoundationDate());
        }
        Restaurant restaurant = restaurantMapper.mapRestaurantInDtoToRestaurant(restaurantInDto);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public LocalDate getFoundationDate(Long id) throws RestaurantNotFoundException {
        Restaurant restaurantById = getRestaurantById(id);
        return restaurantById.getFoundationDate();
    }

    @Override
    public void refactorRestaurantById(Long id, UpdateRestaurantInDto restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) {
            throw new RestaurantNotFoundException(id);
        } else {
            restaurantOptional.get().setName(restaurant.getName());
            restaurantOptional.get().setDescription(restaurant.getDescription());
            restaurantOptional.get().setAddress(restaurant.getAddress());
            restaurantOptional.get().setEmail(restaurant.getEmail());
            restaurantOptional.get().setTelephoneNumber(restaurant.getTelephoneNumber());
        }
    }

    @Override
    public Long createRestaurantByName(String name) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        Restaurant save = restaurantRepository.save(restaurant);
        return save.getId();
    }

    @Override
    public Restaurant createRestaurant(RestaurantInDto restaurantInDto) throws NumberParseException, FoundationDateIsExpiredException {
        if (restaurantInDto.getFoundationDate() == null || LocalDate.now().isBefore(restaurantInDto.getFoundationDate())) {
            throw new FoundationDateIsExpiredException(restaurantInDto.getName(), restaurantInDto.getFoundationDate());
        }
        Restaurant restaurant = restaurantMapper.mapRestaurantInDtoToRestaurant(restaurantInDto);
        return restaurantRepository.save(restaurant);
    }


}
