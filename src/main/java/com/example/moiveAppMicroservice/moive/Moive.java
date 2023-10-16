package com.example.moiveAppMicroservice.moive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Moive {
    @Id
    private String id;
    private String original_language;
    private String original_title;
    @Column(columnDefinition = "TEXT")
    private String overview;
    private String poster_path;
    private Date releaseDate;
    private String vote_average;
    private String vote_count;

}
