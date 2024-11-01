package daw2a.kataapicervezas.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_name", nullable = false, length = 255)
    private String catName;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference(value = "category-beer")
    private List<Beer> beers;
}
