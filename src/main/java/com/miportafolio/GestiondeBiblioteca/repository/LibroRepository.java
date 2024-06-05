package com.miportafolio.GestiondeBiblioteca.repository;
import com.miportafolio.GestiondeBiblioteca.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    Libro buscarLibroPorTitulo(@Param("titulo") String titulo);
    @Query("SELECT l FROM Libro l WHERE l.autor = :autor")
    Libro buscarLibroPorAutor(@Param("autor") String autor);
}
