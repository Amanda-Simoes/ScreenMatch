package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Episodes(@JsonAlias("Title") String title,
                       @JsonAlias("Episode") int episode,
                       @JsonAlias("imdbRating") String assessment,
                       @JsonAlias("Released") String releaseDate) {
}
