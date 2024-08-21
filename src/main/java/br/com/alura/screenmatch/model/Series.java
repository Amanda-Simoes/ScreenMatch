package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Series(@JsonAlias("Title") String title,
                     @JsonAlias("totalSeasons") int seasons,
                     @JsonAlias("imdbRating") String assessment) {
}