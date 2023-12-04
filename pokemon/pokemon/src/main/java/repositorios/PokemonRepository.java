package repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import modelos.Pokemon;
import modelos.Region;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	List<Pokemon> findByRegion(Region region);
}
