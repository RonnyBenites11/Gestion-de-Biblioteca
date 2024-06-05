package com.miportafolio.GestiondeBiblioteca.controller;

import com.miportafolio.GestiondeBiblioteca.entities.DTO.PrestamoDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Prestamo;
import com.miportafolio.GestiondeBiblioteca.service.PrestamoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos")
@Validated
@RequiredArgsConstructor
public class PrestamoController {
    private final PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<Prestamo>> obtenerListaPrestamos() {
        return ResponseEntity.ok(prestamoService.obtenerListaprestamo());
    }

    @PostMapping
    public ResponseEntity<?> registrarNuevoPrestamo(@Valid @RequestBody PrestamoDTO prestamoDTO) {
        try {
            prestamoService.registrarNuevoprestamo(prestamoDTO);
            return new ResponseEntity<>("Préstamo registrado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarprestamo(id);
        return new ResponseEntity<>("Préstamo eliminado exitosamente", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id, @Valid @RequestBody PrestamoDTO prestamoDTO) {
        Prestamo prestamoActualizado = prestamoService.actualizarprestamo(id, prestamoDTO);
        return ResponseEntity.ok(prestamoActualizado);
    }

}
