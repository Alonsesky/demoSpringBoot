package com.example.demo.service.impl;

import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.persistence.entity.Movie;
import com.example.demo.persistence.repository.MovieRepository;
import com.example.demo.service.MovieService;
import com.example.demo.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitleContaining(title);
    }

    @Override
    public List<Movie> findByGenre(MovieGenre genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> findByGenreAndTitle(MovieGenre genre, String title) {
        return movieRepository.findByGenreAndTitleContaining(genre, title);
    }

    @Override
    public Movie findOneById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("[Movie" + Long.toString(id) + "]"));
        return movie;
    }

    @Override
    public Movie createOne(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateOneById(Long id, Movie newMovie) {
        Movie oldMovie = this.findOneById(id);
        oldMovie.setGenre(newMovie.getGenre());
        oldMovie.setReleaseYear(newMovie.getReleaseYear());
        oldMovie.setTitle(newMovie.getTitle());
        oldMovie.setDirector(newMovie.getDirector());

        return movieRepository.save(oldMovie);
    }

    @Override
    public void deleteOneById(Long id) {
        Movie movie = this.findOneById(id);
        movieRepository.delete(movie);
    }
}
