package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Movie;
import com.example.demo.util.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByTitleContaining(String title);

    List<Movie> findByGenre(MovieGenre genre);

    List<Movie> findByGenreAndTitleContaining(MovieGenre genre, String title);
}
