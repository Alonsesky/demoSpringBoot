package com.example.demo.persistence.entity;

import com.example.demo.util.MovieGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String director;

    @Enumerated(EnumType.STRING)
    private MovieGenre genre;

    private int releaseYear;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie")
    private List<Rating> ratings;
}
