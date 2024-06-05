package com.miportafolio.GestiondeBiblioteca.service.impl;

import com.miportafolio.GestiondeBiblioteca.entities.DTO.LibroDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Libro;

import com.miportafolio.GestiondeBiblioteca.repository.LibroRepository;

import com.miportafolio.GestiondeBiblioteca.service.LibroService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service

public class LibroServiceImpl implements LibroService {

 private final LibroRepository libroRepository;



 @Override
 public List<Libro> obtenerListaLibros() {
    return libroRepository.findAll();
 }
 @Override
 public void registrarNuevolibro(LibroDTO libro) {
   Libro libroNuevo = Libro.builder()
           .titulo(libro.getTitulo())
           .autor(libro.getAutor())
           .isbn(libro.getIsbn())
           .disponible(libro.getDisponible())
           .build();
   libroRepository.save(libroNuevo);

 }

 @Override
 public void eliminarlibro(Long id) {
  libroRepository.deleteById(id);
 }

 @Override
 public Libro actualizarlibro(Libro libro) {
  Libro libroUpdated = libroRepository.save(libro);
  return libroUpdated;
 }

 @Override
 public Libro buscarLibroPorTitulo(String titulo) {
  return libroRepository.buscarLibroPorTitulo(titulo);
 }

 @Override
 public Libro buscarLibroPorAutor(String autor) {
  return libroRepository.buscarLibroPorAutor(autor);
 }
 @Override
 public Libro buscarLibroPorId(Long id) {
  Optional<Libro> optionalLibro = libroRepository.findById(id);
  return optionalLibro.orElse(null);
 }


}