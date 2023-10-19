package com.example.movieDetailsMicroservice.controllers;

import com.example.movieDetailsMicroservice.movie.Movie;
import com.example.movieDetailsMicroservice.services.MovieService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class MovieControllerTest {
    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieService;

    @Test
    @DisplayName("Testing getting all movies")
    public void testGetAllMovies() {
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(new Movie("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));
        expectedMovies.add(new Movie("2", "it","title2","overview2","poster2",
                new Date(),"1","1"));
        when(movieService.getAllMovies()).thenReturn(expectedMovies);

        List<Movie> result = movieController.getAllMovies();

        assertEquals(expectedMovies, result);
    }

    @Test
    @DisplayName("Testing adding movies")
    public void testAddMovies() {
        List<Movie> moviesToAdd = new ArrayList<>();
        moviesToAdd.add(new Movie("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));
        moviesToAdd.add(new Movie("2", "it","title2","overview2","poster2",
                new Date(),"1","1"));

        when(movieService.addMovies(any())).thenReturn(moviesToAdd);

        List<Movie> result = movieController.addMovies(moviesToAdd);

        assertEquals(moviesToAdd, result);
    }

    @Test
    @DisplayName("Testing getting movie by ID")
    public void testGetMovieByID() {
        String MovieId = "1";
        Optional<Movie> expectedMovie = Optional.of(new Movie("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));

        when(movieService.getMovieByID(MovieId)).thenReturn(expectedMovie);

        Optional<Movie> result = movieController.getMovieByID(MovieId);

        assertEquals(expectedMovie, result);
    }
    @Test
    @DisplayName("Testing getting movies paginated")
    public void testGetAllMoviesPaginated() {
        int pageNumber = 1;

        List<Movie> expectedMovies = new ArrayList<>();

        Mockito.when(movieService.getAllMoviesPaginated(Mockito.any(Pageable.class)))
                .thenReturn(expectedMovies);

        List<Movie> actualMovies = movieController.getAllMoviesPaginated(pageNumber);

        assertEquals(expectedMovies, actualMovies);
    }
}