package com.miportafolio.GestiondeBiblioteca.repository;
import com.miportafolio.GestiondeBiblioteca.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
