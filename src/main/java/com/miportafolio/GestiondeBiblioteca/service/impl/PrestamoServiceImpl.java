package com.miportafolio.GestiondeBiblioteca.service.impl;

import com.miportafolio.GestiondeBiblioteca.entities.DTO.PrestamoDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Libro;
import com.miportafolio.GestiondeBiblioteca.entities.Prestamo;
import com.miportafolio.GestiondeBiblioteca.entities.Usuario;
import com.miportafolio.GestiondeBiblioteca.repository.LibroRepository;
import com.miportafolio.GestiondeBiblioteca.repository.PrestamoRepository;
import com.miportafolio.GestiondeBiblioteca.repository.UsuarioRepository;
import com.miportafolio.GestiondeBiblioteca.service.PrestamoService;
import com.miportafolio.GestiondeBiblioteca.utils.ErrorNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LibroRepository libroRepository;

    @Override
    public List<Prestamo> obtenerListaprestamo() {

        return prestamoRepository.findAll();
    }

    @Override
    public void registrarNuevoprestamo(PrestamoDTO prestamo) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(prestamo.getUsuario());
        if (!usuarioOptional.isPresent()) {
            throw new ErrorNotFoundException("Usuario no encontrado con ID: " + prestamo.getUsuario());
        }

        Optional<Libro> libroOptional = libroRepository.findById(prestamo.getLibro());
        if (!libroOptional.isPresent()) {
            throw new ErrorNotFoundException("Libro no encontrado con ID: " + prestamo.getLibro());
        }

        LocalDate fechaPrestamo = LocalDate.of(prestamo.getAnioPrestamo(), prestamo.getMesPrestamo(), prestamo.getDiaPrestamo());
        LocalDate fechaDevolucion = LocalDate.of(prestamo.getAnioDevolucion(), prestamo.getMesDevolucion(), prestamo.getDiaDevolucion());

        Prestamo prestamoNuevo = Prestamo.builder()
                .usuario(usuarioOptional.get())
                .libro(libroOptional.get())
                .fechaPrestamo(fechaPrestamo)
                .fechaDevolucion(fechaDevolucion)
                .build();

        prestamoRepository.save(prestamoNuevo);
    }

    @Override
    public void eliminarprestamo(Long id) {
        prestamoRepository.deleteById(id);
    }

    @Override
    public Prestamo actualizarprestamo(Long id, PrestamoDTO prestamo) {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(id);
        if (!prestamoOptional.isPresent()) {
            throw new ErrorNotFoundException("Préstamo no encontrado con ID: " + id);
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(prestamo.getUsuario());
        if (!usuarioOptional.isPresent()) {
            throw new ErrorNotFoundException("Usuario no encontrado con ID: " + prestamo.getUsuario());
        }

        Optional<Libro> libroOptional = libroRepository.findById(prestamo.getLibro());
        if (!libroOptional.isPresent()) {
            throw new ErrorNotFoundException("Libro no encontrado con ID: " + prestamo.getLibro());
        }

        LocalDate fechaPrestamo = LocalDate.of(prestamo.getAnioPrestamo(), prestamo.getMesPrestamo(), prestamo.getDiaPrestamo());
        LocalDate fechaDevolucion = LocalDate.of(prestamo.getAnioDevolucion(), prestamo.getMesDevolucion(), prestamo.getDiaDevolucion());

        Prestamo prestamoExistente = prestamoOptional.get();
        prestamoExistente.setUsuario(usuarioOptional.get());
        prestamoExistente.setLibro(libroOptional.get());
        prestamoExistente.setFechaPrestamo(fechaPrestamo);
        prestamoExistente.setFechaDevolucion(fechaDevolucion);

        return prestamoRepository.save(prestamoExistente);
    }


}
