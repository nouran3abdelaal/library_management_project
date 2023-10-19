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
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMoviesPaginated(Pageable paging){

        Page<Movie> page= movieRepository.findAll(paging);
        return page.getContent();
    }
    public List<Movie> getAllMovies(){

        List<Movie> Movies = new ArrayList<>();
        movieRepository.findAll().forEach(Movies::add);
        return Movies;
    }
    public Optional<Movie> getMovieByID(String Id){
        return  movieRepository.findById(Id);
    }


    public List<Movie> addMovies(List<Movie> Movies) {
        return (List<Movie>) movieRepository.saveAll(Movies);

    }
}
