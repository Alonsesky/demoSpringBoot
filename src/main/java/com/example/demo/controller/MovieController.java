package com.example.demo.controller;

import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.persistence.entity.Movie;
import com.example.demo.service.MovieService;
import com.example.demo.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity<?> findMovies(@RequestParam (required = false) String title){
        List<Movie> movies = null;

        if (StringUtils.hasText(title) && title!=null){
            System.out.println("PASO POR FINDBYTITLE");
            movies = movieService.findByTitle(title);

        } else {
            movies = movieService.findAll();
            System.out.println("PASO POR FINDALL");

        }
        return ResponseEntity.ok(movies);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    ResponseEntity<Movie> findOneById(@PathVariable Long id){

        try {
            Movie movie = movieService.findOneById(id);
            return new ResponseEntity(movie,HttpStatus.OK);
        }catch (ObjectNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }

    @PostMapping("/post")
    public  ResponseEntity<?> createMovie(@RequestBody Movie movie){
        Movie newMovie = movieService.createOne(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovie);
    }
}
