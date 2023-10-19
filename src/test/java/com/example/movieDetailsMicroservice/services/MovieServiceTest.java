package com.example.movieDetailsMicroservice.services;

import com.example.movieDetailsMicroservice.movie.Movie;
import com.example.movieDetailsMicroservice.repositories.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;
@InjectMocks
    private MovieService MovieService;


    @Test
    @DisplayName("Testing getting all the movies")
    public void testGetAllMovies() {
        List<Movie> expectedMovies = new ArrayList<>();
        when(movieRepository.findAll()).thenReturn(expectedMovies);

        List<Movie> actualMovies = MovieService.getAllMovies();

        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    @DisplayName("Testing getting all the movies paginated")
    public void testGetAllMoviesPaginated() {
        List<Movie> expectedMovies = new ArrayList<>();
        Page page = Mockito.mock(Page.class);
        when(movieRepository.findAll(any(Pageable.class))).thenReturn(page);
        when(page.getContent()).thenReturn(expectedMovies);

        List<Movie> actualMovies = MovieService.getAllMoviesPaginated(Pageable.unpaged());

        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void testGetMovieByID() {
        String MovieId = "1";
        Movie expectedMovie = new Movie();
        when(movieRepository.findById(MovieId)).thenReturn(Optional.of(expectedMovie));

        Optional<Movie> actualMovie = MovieService.getMovieByID(MovieId);

        assertEquals(expectedMovie, actualMovie.orElse(null));
    }

    @Test
    public void testAddMovies() {
        List<Movie> Movies = new ArrayList<>();
        when(movieRepository.saveAll(Movies)).thenReturn(Movies);

        List<Movie> savedMovies = MovieService.addMovies(Movies);

        assertEquals(Movies, savedMovies);
    }
}