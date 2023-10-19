package com.example.movieDetailsMicroservice.movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MovieTest {
    @Test
    @DisplayName("Testing the constructor and the getter methods")
    public void testMovieConstructorAndGetters() {
        String id = "1";
        String originalLanguage = "English";
        String originalTitle = "Movie Title";
        String overview = "Movie overview text";
        String posterPath = "path/to/poster.jpg";
        Date releaseDate = new Date();
        String voteAverage = "8.0";
        String voteCount = "1000";

        Movie movie = new Movie(id, originalLanguage, originalTitle, overview, posterPath, releaseDate, voteAverage, voteCount);

        assertEquals(id, movie.getId());
        assertEquals(originalLanguage, movie.getOriginal_language());
        assertEquals(originalTitle, movie.getOriginal_title());
        assertEquals(overview, movie.getOverview());
        assertEquals(posterPath, movie.getPoster_path());
        assertEquals(releaseDate, movie.getReleaseDate());
        assertEquals(voteAverage, movie.getVote_average());
        assertEquals(voteCount, movie.getVote_count());
    }
    @Test
    @DisplayName("Testing the builder")
    public void testMovieBuilder() {
        String id = "1";
        String originalLanguage = "English";
        String originalTitle = "Movie Title";
        String overview = "Movie overview text";
        String posterPath = "path/to/poster.jpg";
        Date releaseDate = new Date();
        String voteAverage = "8.0";
        String voteCount = "1000";

        Movie movie = Movie.builder()
                .id(id)
                .original_language(originalLanguage)
                .original_title(originalTitle)
                .overview(overview)
                .poster_path(posterPath)
                .releaseDate(releaseDate)
                .vote_average(voteAverage)
                .vote_count(voteCount)
                .build();

        assertEquals(id, movie.getId());
        assertEquals(originalLanguage, movie.getOriginal_language());
        assertEquals(originalTitle, movie.getOriginal_title());
        assertEquals(overview, movie.getOverview());
        assertEquals(posterPath, movie.getPoster_path());
        assertEquals(releaseDate, movie.getReleaseDate());
        assertEquals(voteAverage, movie.getVote_average());
        assertEquals(voteCount, movie.getVote_count());
    }

    @Test
    @DisplayName("Testing the setters")
    public void testMovieSetters() {
        Movie movie = new Movie();

        String id = "1";
        String originalLanguage = "English";
        String originalTitle = "Movie Title";
        String overview = "Movie overview text";
        String posterPath = "path/to/poster.jpg";
        Date releaseDate = new Date();
        String voteAverage = "8.0";
        String voteCount = "1000";

        movie.setId(id);
        movie.setOriginal_language(originalLanguage);
        movie.setOriginal_title(originalTitle);
        movie.setOverview(overview);
        movie.setPoster_path(posterPath);
        movie.setReleaseDate(releaseDate);
        movie.setVote_average(voteAverage);
        movie.setVote_count(voteCount);

        assertEquals(id, movie.getId());
        assertEquals(originalLanguage, movie.getOriginal_language());
        assertEquals(originalTitle, movie.getOriginal_title());
        assertEquals(overview, movie.getOverview());
        assertEquals(posterPath, movie.getPoster_path());
        assertEquals(releaseDate, movie.getReleaseDate());
        assertEquals(voteAverage, movie.getVote_average());
        assertEquals(voteCount, movie.getVote_count());
    }



}