package com.example.movieDetailsMicroservice.controllers;

import com.example.movieDetailsMicroservice.movie.Movie;
import com.example.movieDetailsMicroservice.services.MoiveService;
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
    private MoiveService moiveService;

    @Test
    public void testGetAllMoives() {
        List<Movie> expectedMoives = new ArrayList<>();
        expectedMoives.add(new Movie("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));
        expectedMoives.add(new Movie("2", "it","title2","overview2","poster2",
                new Date(),"1","1"));
        when(moiveService.getAllMoives()).thenReturn(expectedMoives);

        List<Movie> result = movieController.getAllMoives();

        assertEquals(expectedMoives, result);
    }

    @Test
    public void testAddMoives() {
        List<Movie> moivesToAdd = new ArrayList<>();
        moivesToAdd.add(new Movie("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));
        moivesToAdd.add(new Movie("2", "it","title2","overview2","poster2",
                new Date(),"1","1"));

        when(moiveService.addMoives(any())).thenReturn(moivesToAdd);

        List<Movie> result = movieController.addMoives(moivesToAdd);

        assertEquals(moivesToAdd, result);
    }

    @Test
    public void testGetMoiveByID() {
        String moiveId = "1";
        Optional<Movie> expectedMoive = Optional.of(new Movie("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));

        when(moiveService.getMoiveByID(moiveId)).thenReturn(expectedMoive);

        Optional<Movie> result = movieController.getMoiveByID(moiveId);

        assertEquals(expectedMoive, result);
    }
    @Test
    public void testGetAllMoivesPaginated() {
        int pageNumber = 1;

        List<Movie> expectedMoives = new ArrayList<>();

        Mockito.when(moiveService.getAllMoivesPaginated(Mockito.any(Pageable.class)))
                .thenReturn(expectedMoives);

        List<Movie> actualMoives = movieController.getAllMoivesPaginated(pageNumber);

        assertEquals(expectedMoives, actualMoives);
    }
}