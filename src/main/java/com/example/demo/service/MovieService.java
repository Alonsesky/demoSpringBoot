package com.example.demo.service;

import com.example.demo.persistence.entity.Movie;
import com.example.demo.util.MovieGenre;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    List<Movie> findByTitle(String title);

    List<Movie> findByGenre(MovieGenre genero);

    List<Movie> findByGenreAndTitle(MovieGenre genre, String title);

    Movie findOneById(Long id);

    Movie createOne(Movie movie);

    Movie updateOneById(Long id, Movie newMovie);

    void deleteOneById(Long id);
}
