package daw2a.kataapicervezas.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "breweries")
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String address1;

    @Column(length = 255)
    private String address2;

    @Column(nullable = false, length = 255)
    private String city;

    @Column(nullable = false, length = 255)
    private String state;

    @Column(nullable = false, length = 25)
    private String code;

    @Column(nullable = false, length = 255)
    private String country;

    @Column(length = 50)
    private String phone;

    @Column(length = 255)
    private String website;

    @Column(length = 255)
    private String filepath;

    @Column(columnDefinition = "TEXT")
    private String descript;

    @Column(name = "add_user", nullable = false)
    private int addUser;

    @Column(name = "last_mod", nullable = false)
    private LocalDateTime lastMod;

    @OneToMany(mappedBy = "brewery")
    @JsonManagedReference(value = "brewery-beer")
    private List<Beer> beers;
}


