package com.movies.demo.movies;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<MoviesModel, Long> {
}
