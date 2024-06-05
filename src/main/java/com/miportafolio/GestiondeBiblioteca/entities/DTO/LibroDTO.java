package com.miportafolio.GestiondeBiblioteca.entities.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;
@Data
public class LibroDTO {
    private Long id;
    @Size(min = 5, max = 15,  message = "El titulo debe tener entre 5 y 15 caracteres")
    private String titulo;
    @Size(min = 5, max = 15 , message = "El autor debe tener entre 5 y 15 caracteres")
    private String autor;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String isbn;

    private Boolean disponible = true ;


}
