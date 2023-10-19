package com.example.movieDetailsMicroservice.services;
import com.example.movieDetailsMicroservice.movie.Movie;
import com.example.movieDetailsMicroservice.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoiveService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMoivesPaginated(Pageable paging){

        Page<Movie> page= movieRepository.findAll(paging);
        return page.getContent();
    }
    public List<Movie> getAllMoives(){

        List<Movie> Moives = new ArrayList<>();
        movieRepository.findAll().forEach(Moives::add);
        return Moives;
    }
    public Optional<Movie> getMoiveByID(String Id){
        return  movieRepository.findById(Id);
    }


    public List<Movie> addMoives(List<Movie> moives) {
        return (List<Movie>) movieRepository.saveAll(moives);

    }
}
