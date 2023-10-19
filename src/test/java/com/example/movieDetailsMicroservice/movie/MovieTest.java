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
    public void testMoiveConstructorAndGetters() {
        String id = "1";
        String originalLanguage = "English";
        String originalTitle = "Movie Title";
        String overview = "Movie overview text";
        String posterPath = "path/to/poster.jpg";
        Date releaseDate = new Date();
        String voteAverage = "8.0";
        String voteCount = "1000";

        Movie moive = new Movie(id, originalLanguage, originalTitle, overview, posterPath, releaseDate, voteAverage, voteCount);

        assertEquals(id, moive.getId());
        assertEquals(originalLanguage, moive.getOriginal_language());
        assertEquals(originalTitle, moive.getOriginal_title());
        assertEquals(overview, moive.getOverview());
        assertEquals(posterPath, moive.getPoster_path());
        assertEquals(releaseDate, moive.getReleaseDate());
        assertEquals(voteAverage, moive.getVote_average());
        assertEquals(voteCount, moive.getVote_count());
    }
    @Test
    @DisplayName("Testing the builder")
    public void testMoiveBuilder() {
        String id = "1";
        String originalLanguage = "English";
        String originalTitle = "Movie Title";
        String overview = "Movie overview text";
        String posterPath = "path/to/poster.jpg";
        Date releaseDate = new Date();
        String voteAverage = "8.0";
        String voteCount = "1000";

        Movie moive = Movie.builder()
                .id(id)
                .original_language(originalLanguage)
                .original_title(originalTitle)
                .overview(overview)
                .poster_path(posterPath)
                .releaseDate(releaseDate)
                .vote_average(voteAverage)
                .vote_count(voteCount)
                .build();

        assertEquals(id, moive.getId());
        assertEquals(originalLanguage, moive.getOriginal_language());
        assertEquals(originalTitle, moive.getOriginal_title());
        assertEquals(overview, moive.getOverview());
        assertEquals(posterPath, moive.getPoster_path());
        assertEquals(releaseDate, moive.getReleaseDate());
        assertEquals(voteAverage, moive.getVote_average());
        assertEquals(voteCount, moive.getVote_count());
    }

    @Test
    @DisplayName("Testing the setters")
    public void testMoiveSetters() {
        Movie moive = new Movie();

        String id = "1";
        String originalLanguage = "English";
        String originalTitle = "Movie Title";
        String overview = "Movie overview text";
        String posterPath = "path/to/poster.jpg";
        Date releaseDate = new Date();
        String voteAverage = "8.0";
        String voteCount = "1000";

        moive.setId(id);
        moive.setOriginal_language(originalLanguage);
        moive.setOriginal_title(originalTitle);
        moive.setOverview(overview);
        moive.setPoster_path(posterPath);
        moive.setReleaseDate(releaseDate);
        moive.setVote_average(voteAverage);
        moive.setVote_count(voteCount);

        assertEquals(id, moive.getId());
        assertEquals(originalLanguage, moive.getOriginal_language());
        assertEquals(originalTitle, moive.getOriginal_title());
        assertEquals(overview, moive.getOverview());
        assertEquals(posterPath, moive.getPoster_path());
        assertEquals(releaseDate, moive.getReleaseDate());
        assertEquals(voteAverage, moive.getVote_average());
        assertEquals(voteCount, moive.getVote_count());
    }



}