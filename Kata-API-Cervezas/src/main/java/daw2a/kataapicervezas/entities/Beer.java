package daw2a.kataapicervezas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "beers")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brewery_id", nullable = false)
    @JsonBackReference(value = "brewery-beer")
    private Brewery brewery;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = true)
    @JsonBackReference(value = "category-beer")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "style_id", nullable = true)
    @JsonBackReference(value = "style-beer")
    private Style style;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private float abv;

    @Column(nullable = false)
    private float ibu;

    @Column(nullable = false)
    private float srm;

    @Column(nullable = false)
    private int upc;

    @Column(length = 255)
    private String filepath;

    @Column(columnDefinition = "TEXT")
    private String descript;

    @Column(name = "add_user", nullable = false)
    private int addUser;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;
}
