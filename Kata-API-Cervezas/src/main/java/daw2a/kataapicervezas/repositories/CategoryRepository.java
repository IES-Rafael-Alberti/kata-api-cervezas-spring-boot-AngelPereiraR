package daw2a.kataapicervezas.repositories;

import daw2a.kataapicervezas.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
