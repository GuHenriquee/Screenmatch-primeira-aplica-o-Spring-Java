package br.com.alura.screenmatch;

import br.com.alura.screenmatch.models.DadosEpisodios;
import br.com.alura.screenmatch.models.DadosSerie;
import br.com.alura.screenmatch.models.Temporadas;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverterDados;
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
        var consumoApi = new ConsumoApi();

        var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=7a3c71f9");
        System.out.println(json);
        ConverterDados conversor = new ConverterDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println("Dados da serie: " + dados);

        List<Temporadas> listaTemporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=7a3c71f9");
            Temporadas dadosTemporadas = conversor.obterDados(json, Temporadas.class);
            listaTemporadas.add(dadosTemporadas);

        }
        listaTemporadas.forEach(System.out::println);

        json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=7a3c71f9");
        DadosEpisodios dadosEpisodio = conversor.obterDados(json, DadosEpisodios.class);
        System.out.println("Dados do episodio: " + dadosEpisodio);
    }
}
