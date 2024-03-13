package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelos.Entrenador;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

}