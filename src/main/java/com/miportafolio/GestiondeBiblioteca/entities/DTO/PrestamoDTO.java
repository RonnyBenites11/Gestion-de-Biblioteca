package com.miportafolio.GestiondeBiblioteca.entities.DTO;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class PrestamoDTO {
    @NotNull(message = "ID de usuario es obligatorio")
    private Long usuario;

    @NotNull(message = "ID de libro es obligatorio")
    private Long libro;

    @NotNull(message = "El día de préstamo no debe ser nulo")
    @Min(value = 1, message = "El día de préstamo debe ser entre 1 y 31")
    @Max(value = 31, message = "El día de préstamo debe ser entre 1 y 31")
    private Integer diaPrestamo;

    @NotNull(message = "El mes de préstamo no debe ser nulo")
    @Min(value = 1, message = "El mes de préstamo debe ser entre 1 y 12")
    @Max(value = 12, message = "El mes de préstamo debe ser entre 1 y 12")
    private Integer mesPrestamo;

    @NotNull(message = "El año de préstamo no debe ser nulo")
    @Min(value = 1900, message = "El año de préstamo debe ser razonable")
    private Integer anioPrestamo;

    @NotNull(message = "El día de devolución no debe ser nulo")
    @Min(value = 1, message = "El día de devolución debe ser entre 1 y 31")
    @Max(value = 31, message = "El día de devolución debe ser entre 1 y 31")
    private Integer diaDevolucion;

    @NotNull(message = "El mes de devolución no debe ser nulo")
    @Min(value = 1, message = "El mes de devolución debe ser entre 1 y 12")
    @Max(value = 12, message = "El mes de devolución debe ser entre 1 y 12")
    private Integer mesDevolucion;

    @NotNull(message = "El año de devolución no debe ser nulo")
    @Min(value = 1900, message = "El año de devolución debe ser razonable")
    private Integer anioDevolucion;

}
