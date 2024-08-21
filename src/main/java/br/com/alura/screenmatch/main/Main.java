package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.model.Episodes;
import br.com.alura.screenmatch.model.Seasons;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.service.ConsumeApi;
import br.com.alura.screenmatch.service.ConvertsData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static String INITIAL_URL = "https://www.omdbapi.com/?t=";
    private final static String ENDING_URL = "&apikey=6585022c";

    private final Scanner reading = new Scanner(System.in);
    private final ConsumeApi consumeApi = new ConsumeApi();
    private final ConvertsData convertsData = new ConvertsData();

    public void displayMenu () {

        System.out.println("Informe o nome da Série: ");
        String name = reading.nextLine();

        String json = consumeApi.getData(INITIAL_URL + name.replace(" ", "+") + ENDING_URL);
        Series series = convertsData.getData(json, Series.class);
        System.out.println(series);

        List<Seasons> seasonsList = new ArrayList<>();

        for(int i = 1; i<=series.seasons(); i++) {
            String result = consumeApi.getData(INITIAL_URL + name.replace(" ", "+") + "&season=" + i + ENDING_URL);
            seasonsList.add(convertsData.getData(result, Seasons.class));
        }

        seasonsList.forEach(System.out::println);

        seasonsList.forEach(episode -> {
            episode.episodes().forEach(item -> {
                System.out.println(item.title());
            });
        });
    }

}
