package com.example.movieDetailsMicroservice.repositories;

import com.example.movieDetailsMicroservice.movie.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,String> {
    Page<Movie> findAll(Pageable pageable);

}
