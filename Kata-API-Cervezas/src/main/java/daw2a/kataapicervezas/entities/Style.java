package daw2a.kataapicervezas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    @JsonBackReference
    private Category category;

    @Column(name = "style_name", nullable = false, length = 255)
    private String styleName;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;

    @OneToMany(mappedBy = "style")
    @JsonManagedReference(value = "style-beer")
    private List<Beer> beers;
}
