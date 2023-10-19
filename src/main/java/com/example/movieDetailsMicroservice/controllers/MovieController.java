package com.example.movieDetailsMicroservice.controllers;

import com.example.movieDetailsMicroservice.movie.Movie;
import com.example.movieDetailsMicroservice.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService MovieService;

    @RequestMapping("/Movies")
    public List<Movie> getAllMovies() {
         return  MovieService.getAllMovies();
    }

@RequestMapping("/Movies/{Page_number}")
public List<Movie> getAllMoviesPaginated(@PathVariable int Page_number) {
    int itemsPerPage = 5;
    Pageable paging = PageRequest.of(Page_number-1, itemsPerPage, Sort.by("releaseDate").ascending());
    return  MovieService.getAllMoviesPaginated(paging);
}


    @RequestMapping(method = RequestMethod.POST, value = "/Movies")
    public List<Movie> addMovies(@RequestBody List<Movie> Movies) {
        return MovieService.addMovies(Movies);
    }

    @RequestMapping("/Movie/{Id}")
    public Optional<Movie> getMovieByID(@PathVariable String Id){

        return MovieService.getMovieByID(Id);
    }



}
