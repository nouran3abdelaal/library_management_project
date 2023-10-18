package com.example.moiveAppMicroservice.services;

import com.example.moiveAppMicroservice.moive.Moive;
import com.example.moiveAppMicroservice.repositories.MoiveRepository;
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
class MoiveServiceTest {
    @Mock
    private MoiveRepository moiveRepository;
@InjectMocks
    private MoiveService moiveService;


    @Test
    public void testGetAllMoives() {
        List<Moive> expectedMoives = new ArrayList<>();
        when(moiveRepository.findAll()).thenReturn(expectedMoives);

        List<Moive> actualMoives = moiveService.getAllMoives();

        assertEquals(expectedMoives, actualMoives);
    }

    @Test
    public void testGetAllMoivesPaginated() {
        List<Moive> expectedMoives = new ArrayList<>();
        Page page = Mockito.mock(Page.class);
        when(moiveRepository.findAll(any(Pageable.class))).thenReturn(page);
        when(page.getContent()).thenReturn(expectedMoives);

        List<Moive> actualMoives = moiveService.getAllMoivesPaginated(Pageable.unpaged());

        assertEquals(expectedMoives, actualMoives);
    }

    @Test
    public void testGetMoiveByID() {
        String moiveId = "1";
        Moive expectedMoive = new Moive();
        when(moiveRepository.findById(moiveId)).thenReturn(Optional.of(expectedMoive));

        Optional<Moive> actualMoive = moiveService.getMoiveByID(moiveId);

        assertEquals(expectedMoive, actualMoive.orElse(null));
    }

    @Test
    public void testAddMoives() {
        List<Moive> moives = new ArrayList<>();
        when(moiveRepository.saveAll(moives)).thenReturn(moives);

        List<Moive> savedMoives = moiveService.addMoives(moives);

        assertEquals(moives, savedMoives);
    }
}