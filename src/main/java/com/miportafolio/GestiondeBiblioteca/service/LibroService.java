package com.miportafolio.GestiondeBiblioteca.service;
import com.miportafolio.GestiondeBiblioteca.entities.DTO.LibroDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> obtenerListaLibros();
    void registrarNuevolibro(LibroDTO libro);
    void eliminarlibro (Long id);
    Libro actualizarlibro(Libro libro);
    Libro buscarLibroPorTitulo(String titulo);
    Libro buscarLibroPorAutor (String autor);
    Libro buscarLibroPorId(Long id);
}
