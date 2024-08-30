package com.example.demo.controller;

import com.example.demo.persistence.entity.Movie;
import com.example.demo.service.MovieService;
import com.example.demo.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    

    @PostMapping("/post")
    public  ResponseEntity<?> createMovie(@RequestBody Movie movie){
        Movie newMovie = movieService.createOne(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }
}
