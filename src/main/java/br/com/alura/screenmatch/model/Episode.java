package br.com.alura.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;

public class Episode {

    private int season;
    private String title;
    private Integer episodeNumber;
    private Double assessment;
    private LocalDate releaseDate;

    public Episode(int season, Episodes episodes) {
        this.season = season;
        this.title = episodes.title();
        this.episodeNumber = episodes.episode();
        try {
            this.assessment = Double.valueOf(episodes.assessment());
        } catch (NumberFormatException ex) {
            this.assessment = 0.0;
        }
        try {
            this.releaseDate = LocalDate.parse(episodes.releaseDate());
        } catch (DateTimeParseException ex) {
            this.releaseDate = null;
        }
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getAssessment() {
        return assessment;
    }

    public void setAssessment(Double assessment) {
        this.assessment = assessment;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "season=" + season +
                ", title='" + title + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", assessment=" + assessment +
                ", releaseDate=" + releaseDate;
    }
}
