package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelos.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
