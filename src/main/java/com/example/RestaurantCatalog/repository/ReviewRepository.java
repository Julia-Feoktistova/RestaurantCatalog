package com.example.RestaurantCatalog.repository;

import com.example.RestaurantCatalog.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Optional<List<Review>> findAllById(Integer id);

}
