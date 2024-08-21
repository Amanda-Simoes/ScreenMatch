package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.service.ConsumeApi;

import java.util.Scanner;

public class Main {

    private final String INITIAL_URL = "https://www.omdbapi.com/?t=";
    private final String ENDING_URL = "&apikey=6585022c";

    private final Scanner reading = new Scanner(System.in);
    private final ConsumeApi consumeApi = new ConsumeApi();

    public void displayMenu () {

        System.out.println("Informe o nome da Série: ");
        String name = reading.nextLine();

        String json = consumeApi.getData(INITIAL_URL + name.replace(" ", "+") + ENDING_URL);
        System.out.println(json);
    }

}
