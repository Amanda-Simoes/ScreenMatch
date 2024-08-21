package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Episodes;
import br.com.alura.screenmatch.model.Seasons;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.service.ConsumeApi;
import br.com.alura.screenmatch.service.ConvertsData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConvertsData convertsData = new ConvertsData();

		ConsumeApi consumeApi = new ConsumeApi();
		String data = consumeApi.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		String dataEpisodes = consumeApi.getData("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");

		Series series = convertsData.getData(data, Series.class);
		System.out.println(series);

		Episodes episodes = convertsData.getData(dataEpisodes, Episodes.class);
		System.out.println(episodes);

		List<Seasons> seasonsList = new ArrayList<>();

		for(int i = 1; i<=series.seasons(); i++) {
			String result = consumeApi.getData("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
			seasonsList.add(convertsData.getData(result, Seasons.class));
		}

		seasonsList.forEach(System.out::println);
	}
}
