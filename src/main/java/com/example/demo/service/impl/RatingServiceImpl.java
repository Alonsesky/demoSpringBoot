package com.example.demo.service.impl;

import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.persistence.entity.Rating;
import com.example.demo.persistence.repository.RatingRepository;
import com.example.demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating findOneById(Long id) {
        return  ratingRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("[rating"+ Long.toString(id) + "]"));
    }


    @Override
    public List<Rating> findAllByMovieId(Long id) {
        return ratingRepository.findByMovieId(id);
    }

    @Override
    public List<Rating> findByAllUsername(String username) {
        return ratingRepository.findByUsername(username);
    }

    @Override
    public Rating createOne(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateOneById(Long id, Rating newRating) {
        Rating oldRating = this.findOneById(id);
        oldRating.setUserId(newRating.getUserId());
        oldRating.setMovieId(newRating.getMovieId());

        return ratingRepository.save(oldRating);
    }

    @Override
    public void deleteOneByid(Long id) {
        if (ratingRepository.existsById(id)){
            ratingRepository.deleteById(id);
            return;
        }
        throw new ObjectNotFoundException(("[rating"+ Long.toString(id) + "]"));
    }
}
