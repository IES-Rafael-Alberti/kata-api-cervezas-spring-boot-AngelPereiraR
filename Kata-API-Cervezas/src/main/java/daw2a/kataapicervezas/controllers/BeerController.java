package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Beer;
import daw2a.kataapicervezas.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beers")
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @GetMapping
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Beer> addBeer(@RequestBody Beer beer) {
        Beer savedBeer = beerRepository.save(beer);
        return new ResponseEntity<>(savedBeer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable Long id) {
        Optional<Beer> beer = beerRepository.findById(id);
        return beer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeer(@PathVariable Long id) {
        if (beerRepository.existsById(id)) {
            beerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beer> updateBeer(@PathVariable Long id, @RequestBody Beer beerDetails) {
        Optional<Beer> existingBeer = beerRepository.findById(id);
        if (existingBeer.isPresent()) {
            Beer beer = existingBeer.get();
            if (beerDetails.getName() != null) beer.setName(beerDetails.getName());
            if (beerDetails.getAbv() != 0) beer.setAbv(beerDetails.getAbv());
            if (beerDetails.getIbu() != 0) beer.setIbu(beerDetails.getIbu());
            if (beerDetails.getSrm() != 0) beer.setSrm(beerDetails.getSrm());
            if (beerDetails.getUpc() != 0) beer.setUpc(beerDetails.getUpc());
            if (beerDetails.getFilepath() != null) beer.setFilepath(beerDetails.getFilepath());
            if (beerDetails.getDescript() != null) beer.setDescript(beerDetails.getDescript());
            if (beerDetails.getAddUser() != 0) beer.setAddUser(beerDetails.getAddUser());
            if (beerDetails.getBrewery() != null) beer.setBrewery(beerDetails.getBrewery());
            if (beerDetails.getCategory() != null) beer.setCategory(beerDetails.getCategory());
            if (beerDetails.getStyle() != null) beer.setStyle(beerDetails.getStyle());
            beerRepository.save(beer);
            return ResponseEntity.ok(beer);
        }
        return ResponseEntity.notFound().build();
    }
}
