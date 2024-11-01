package daw2a.kataapicervezas.repositories;

import daw2a.kataapicervezas.entities.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Long> {
}
