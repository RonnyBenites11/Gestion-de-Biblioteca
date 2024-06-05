package com.miportafolio.GestiondeBiblioteca.controller;

import com.miportafolio.GestiondeBiblioteca.entities.DTO.UsuarioDTO;
import com.miportafolio.GestiondeBiblioteca.entities.Usuario;
import com.miportafolio.GestiondeBiblioteca.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
@Validated
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerListaUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerListausuario());
    }

    @PostMapping
    public ResponseEntity<String> registrarNuevoUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.registrarNuevousuario(usuarioDTO);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarusuario(id);
        return new ResponseEntity<>("Usuario eliminado exitosamente", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarUsuarioPorId(id);
        if (!usuarioOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Usuario usuarioExistente = usuarioOptional.get();
        usuarioExistente.setNombre(usuarioDTO.getNombre());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setPassword(usuarioDTO.getPassword());

        Usuario usuarioActualizado = usuarioService.actualizarusuario(usuarioExistente);
        return ResponseEntity.ok(usuarioActualizado);
    }
}
