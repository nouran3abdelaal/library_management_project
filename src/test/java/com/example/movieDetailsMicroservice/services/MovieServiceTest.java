package com.example.movieDetailsMicroservice.services;

import com.example.movieDetailsMicroservice.movie.Movie;
import com.example.movieDetailsMicroservice.repositories.MovieRepository;
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
    private MoiveService moiveService;


    @Test
    public void testGetAllMoives() {
        List<Movie> expectedMoives = new ArrayList<>();
        when(movieRepository.findAll()).thenReturn(expectedMoives);

        List<Movie> actualMoives = moiveService.getAllMoives();

        assertEquals(expectedMoives, actualMoives);
    }

    @Test
    public void testGetAllMoivesPaginated() {
        List<Movie> expectedMoives = new ArrayList<>();
        Page page = Mockito.mock(Page.class);
        when(movieRepository.findAll(any(Pageable.class))).thenReturn(page);
        when(page.getContent()).thenReturn(expectedMoives);

        List<Movie> actualMoives = moiveService.getAllMoivesPaginated(Pageable.unpaged());

        assertEquals(expectedMoives, actualMoives);
    }

    @Test
    public void testGetMoiveByID() {
        String moiveId = "1";
        Movie expectedMoive = new Movie();
        when(movieRepository.findById(moiveId)).thenReturn(Optional.of(expectedMoive));

        Optional<Movie> actualMoive = moiveService.getMoiveByID(moiveId);

        assertEquals(expectedMoive, actualMoive.orElse(null));
    }

    @Test
    public void testAddMoives() {
        List<Movie> moives = new ArrayList<>();
        when(movieRepository.saveAll(moives)).thenReturn(moives);

        List<Movie> savedMoives = moiveService.addMoives(moives);

        assertEquals(moives, savedMoives);
    }
}