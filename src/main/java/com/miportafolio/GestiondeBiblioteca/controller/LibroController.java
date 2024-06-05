package com.miportafolio.GestiondeBiblioteca.controller;

import com.miportafolio.GestiondeBiblioteca.entities.DTO.LibroDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Libro;
import com.miportafolio.GestiondeBiblioteca.service.LibroService;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/libro")
@RequiredArgsConstructor
@Validated
public class LibroController {
    private final LibroService libroServices;

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerListaLibros() {
        return ResponseEntity.ok(libroServices.obtenerListaLibros());
    }

    @PostMapping
    public ResponseEntity<String> postRegistrarLibro(@Valid @RequestBody LibroDTO libro) {
        libroServices.registrarNuevolibro(libro);
        return new ResponseEntity<>("Libro fue registrado", HttpStatus.CREATED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> errorMessages.add(error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errorMessages);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarlibro(@PathVariable Long id) {
        libroServices.eliminarlibro(id);
        return new ResponseEntity<>("Libro eliminado exitosamente", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarlibro(@PathVariable Long id, @Valid @RequestBody LibroDTO libroDTO) {
        Libro libro = libroServices.buscarLibroPorId(id);
        if (libro != null) {
            libro.setTitulo(libroDTO.getTitulo());
            libro.setAutor(libroDTO.getAutor());
            libro.setIsbn(libroDTO.getIsbn());
            libro.setDisponible(libroDTO.getDisponible());
            return ResponseEntity.ok(libroServices.actualizarlibro(libro));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Libro> buscarLibroPorTitulo(@PathVariable String titulo) {
        Libro libro = libroServices.buscarLibroPorTitulo(titulo);
        return libro != null ? ResponseEntity.ok(libro) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<Libro> buscarLibroPorAutor(@PathVariable String autor) {
        Libro libro = libroServices.buscarLibroPorAutor(autor);
        return libro != null ? ResponseEntity.ok(libro) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
