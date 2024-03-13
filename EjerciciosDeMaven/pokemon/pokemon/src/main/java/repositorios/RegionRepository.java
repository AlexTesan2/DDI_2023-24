package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import modelos.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

}