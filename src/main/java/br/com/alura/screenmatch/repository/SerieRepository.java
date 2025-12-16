package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.models.Categoria;
import br.com.alura.screenmatch.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);
    //Uma que funciona query feita apenas a partir do nome da funcao

    List<Serie> findByatoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

}
