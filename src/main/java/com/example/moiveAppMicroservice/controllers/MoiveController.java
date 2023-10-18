package com.example.moiveAppMicroservice.controllers;

import com.example.moiveAppMicroservice.moive.Moive;
import com.example.moiveAppMicroservice.services.MoiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/moive")
public class MoiveController {
    private final MoiveService moiveService;

    @RequestMapping("/Moives")
    public List<Moive> getAllMoives() {
         return  moiveService.getAllMoives();
    }

@RequestMapping("/Moives/{Page_number}")
public List<Moive> getAllMoivesPaginated(@PathVariable int Page_number) {
    int itemsPerPage = 5;
    Pageable paging = PageRequest.of(Page_number-1, itemsPerPage, Sort.by("releaseDate").ascending());
    return  moiveService.getAllMoivesPaginated(paging);
}


    @RequestMapping(method = RequestMethod.POST, value = "/Moives")
    public List<Moive> addMoives(@RequestBody List<Moive> moives) {
        return moiveService.addMoives(moives);
    }

    @RequestMapping("/Moive/{Id}")
    public Optional<Moive> getMoiveByID(@PathVariable String Id){

        return moiveService.getMoiveByID(Id);
    }



}
