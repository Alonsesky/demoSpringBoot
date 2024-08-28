package com.example.demo.service;

import com.example.demo.persistence.entity.Movie;
import com.example.demo.persistence.entity.Rating;


import java.util.List;

public interface RatingService {

    List<Rating>findAll();

    Rating findOneById(Long id);

    List<Rating> findAllByMovieId(Long id);

    List<Rating> findByAllUsername(String username);

    Rating createOne(Rating rating);

    Rating updateOneById(Long id, Rating rating);

    void deleteOneByid(Long id);
}
