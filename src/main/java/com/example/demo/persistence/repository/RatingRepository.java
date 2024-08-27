package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository  extends JpaRepository<Rating, Long> {

    List<Rating> findByMovieId(Long id);
    
    List<Rating> findByUserAccountUsername(String username);

    @Query("SELECT r FROM Rating r JOIN r.userAccount u WHERE u.username = ?1")
    List<Rating> findByUsername(String username);
}
