package com.miportafolio.GestiondeBiblioteca.service;

import com.miportafolio.GestiondeBiblioteca.entities.DTO.UsuarioDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> obtenerListausuario();
    void registrarNuevousuario(UsuarioDTO usuario);
    void eliminarusuario (Long id);
    Usuario actualizarusuario(Usuario usuario);
    Optional<Usuario> buscarUsuarioPorId(Long id);
}
