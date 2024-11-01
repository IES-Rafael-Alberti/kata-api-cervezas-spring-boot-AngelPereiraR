package daw2a.kataapicervezas.repositories;

import daw2a.kataapicervezas.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
}

