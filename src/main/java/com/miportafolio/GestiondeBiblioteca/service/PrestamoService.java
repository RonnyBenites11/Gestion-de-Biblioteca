package com.miportafolio.GestiondeBiblioteca.service;
import com.miportafolio.GestiondeBiblioteca.entities.DTO.PrestamoDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Prestamo;


import java.util.List;

public interface PrestamoService {
    List<Prestamo> obtenerListaprestamo();
    void registrarNuevoprestamo(PrestamoDTO prestamo);
    void eliminarprestamo (Long id);
    Prestamo actualizarprestamo(Long id, PrestamoDTO prestamo);
}
