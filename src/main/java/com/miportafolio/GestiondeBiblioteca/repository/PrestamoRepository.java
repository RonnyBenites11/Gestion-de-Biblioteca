package com.miportafolio.GestiondeBiblioteca.repository;


import com.miportafolio.GestiondeBiblioteca.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}
