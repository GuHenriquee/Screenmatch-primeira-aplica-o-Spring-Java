package br.com.alura.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodios(@JsonAlias ("Title") String titulo,
                             @JsonAlias ("Episode")int numero,
                             @JsonAlias ("imdbRating")String avaliacao,
                             @JsonAlias ("Released") String dataLancamento) {
}
