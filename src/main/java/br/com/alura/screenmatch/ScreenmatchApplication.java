package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.service.ConsumeApi;
import br.com.alura.screenmatch.service.ConvertsData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumeApi consumeApi = new ConsumeApi();
		String data = consumeApi.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		ConvertsData convertsData = new ConvertsData();
		Series series = convertsData.getData(data, Series.class);
		System.out.println(series);
	}
}
