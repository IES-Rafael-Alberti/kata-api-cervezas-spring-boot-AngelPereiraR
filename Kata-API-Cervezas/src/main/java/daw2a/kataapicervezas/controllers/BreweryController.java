package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Brewery;
import daw2a.kataapicervezas.repositories.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/breweries")
public class BreweryController {

    @Autowired
    private BreweryRepository breweryRepository;

    @GetMapping
    public List<Brewery> getAllBreweries() {
        return breweryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brewery> getBreweryById(@PathVariable Long id) {
        Optional<Brewery> brewery = breweryRepository.findById(id);
        return brewery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
