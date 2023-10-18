package com.example.moiveAppMicroservice.controllers;

import com.example.moiveAppMicroservice.moive.Moive;
import com.example.moiveAppMicroservice.services.MoiveService;
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
class MoiveControllerTest {
    @InjectMocks
    private MoiveController moiveController;

    @Mock
    private MoiveService moiveService;

    @Test
    public void testGetAllMoives() {
        List<Moive> expectedMoives = new ArrayList<>();
        expectedMoives.add(new Moive("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));
        expectedMoives.add(new Moive("2", "it","title2","overview2","poster2",
                new Date(),"1","1"));
        when(moiveService.getAllMoives()).thenReturn(expectedMoives);

        List<Moive> result = moiveController.getAllMoives();

        assertEquals(expectedMoives, result);
    }

    @Test
    public void testAddMoives() {
        List<Moive> moivesToAdd = new ArrayList<>();
        moivesToAdd.add(new Moive("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));
        moivesToAdd.add(new Moive("2", "it","title2","overview2","poster2",
                new Date(),"1","1"));

        when(moiveService.addMoives(any())).thenReturn(moivesToAdd);

        List<Moive> result = moiveController.addMoives(moivesToAdd);

        assertEquals(moivesToAdd, result);
    }

    @Test
    public void testGetMoiveByID() {
        String moiveId = "1";
        Optional<Moive> expectedMoive = Optional.of(new Moive("1", "it","La vita è bella","overview1","poster1",
                new Date(),"1","1"));

        when(moiveService.getMoiveByID(moiveId)).thenReturn(expectedMoive);

        Optional<Moive> result = moiveController.getMoiveByID(moiveId);

        assertEquals(expectedMoive, result);
    }
    @Test
    public void testGetAllMoivesPaginated() {
        int pageNumber = 1;

        List<Moive> expectedMoives = new ArrayList<>();

        Mockito.when(moiveService.getAllMoivesPaginated(Mockito.any(Pageable.class)))
                .thenReturn(expectedMoives);

        List<Moive> actualMoives = moiveController.getAllMoivesPaginated(pageNumber);

        assertEquals(expectedMoives, actualMoives);
    }
}