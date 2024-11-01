package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Style;
import daw2a.kataapicervezas.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/styles")
public class StyleController {

    @Autowired
    private StyleRepository styleRepository;

    @GetMapping
    public List<Style> getAllStyles() {
        return styleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Style> getStyleById(@PathVariable Long id) {
        Optional<Style> style = styleRepository.findById(id);
        return style.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

