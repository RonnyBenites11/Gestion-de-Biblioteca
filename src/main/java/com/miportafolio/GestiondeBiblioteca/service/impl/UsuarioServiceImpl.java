package com.miportafolio.GestiondeBiblioteca.service.impl;

import com.miportafolio.GestiondeBiblioteca.entities.DTO.UsuarioDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Libro;
import com.miportafolio.GestiondeBiblioteca.entities.Usuario;
import com.miportafolio.GestiondeBiblioteca.repository.UsuarioRepository;
import com.miportafolio.GestiondeBiblioteca.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> obtenerListausuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public void registrarNuevousuario(UsuarioDTO usuario) {
        Usuario usuarioNuevo = Usuario.builder()
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .password(usuario.getPassword())
                .build();
        usuarioRepository.save(usuarioNuevo);
    }

    @Override
    public void eliminarusuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario actualizarusuario(Usuario usuario) {
        Usuario usuarioUpdated = usuarioRepository.save(usuario);
        return usuarioUpdated;
    }
    @Override
    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }
}
